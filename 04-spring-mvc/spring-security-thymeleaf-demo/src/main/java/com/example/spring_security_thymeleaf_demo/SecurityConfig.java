package com.example.spring_security_thymeleaf_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//https://www.baeldung.com/spring-boot-keycloak
//https://stackoverflow.com/questions/62354754/how-to-get-the-roles-in-access-token-keycloak

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login").permitAll()
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )

                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo ->
                                userInfo.oidcUserService(oidcUserService()))
                )
                .oidcLogout(oidc->oidc.backChannel(Customizer.withDefaults()))
                .logout(logout ->
                        logout.logoutSuccessUrl("/")
                        //logout.logoutSuccessUrl("http://localhost:7080/realms/MyAppRealm/protocol/openid-connect/logout?redirect_uri=http://localhost:8090/")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }
    @Bean
    public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
        OidcUserService delegate = new OidcUserService();
        return userRequest -> {
            OidcUser oidcUser = delegate.loadUser(userRequest);

            // Extract roles from Keycloak token (realm_access.roles)
            List<String> roles = oidcUser.getClaimAsMap("realm_access") != null
                    ? (List<String>) oidcUser.getClaimAsMap("realm_access").get("roles")
                    : List.of();
            System.out.println("ID Token Claims: " + oidcUser.getIdToken().getClaims());
            System.out.println("User Info Claims: " + oidcUser.getUserInfo().getClaims());

            System.out.println("Keycloak roles: " + roles);
            Collection<GrantedAuthority> mappedAuthorities = roles.stream()
                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                    .collect(Collectors.toList());
            return new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
        };
    }
}
