package com.example.spring_security_db_demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());*/
        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll());*/
        http.authorizeHttpRequests((requests) -> requests
                .requestMatchers(("/admin")).hasRole("ADMIN")
                .requestMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards")
                .hasAnyRole("ADMIN","USER")
                .requestMatchers("/notices", "/contact", "/register","/error").permitAll()
                .anyRequest().authenticated());

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")  // The logout URL
                        .invalidateHttpSession(true)  // Invalidate the session
                        .clearAuthentication(true)  // Clear authentication details
                        .deleteCookies("JSESSIONID")  // Delete the session cookie
                        .permitAll()  // Make logout accessible to everyone
                );
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

}
