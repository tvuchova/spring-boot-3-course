package com.example.spring_security_auth2_demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@Slf4j
@RestController
@AllArgsConstructor
public class HomeController {
    private final OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("/")
    public String home() {
        return "Hello, not secured!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello, secured!";
    }

    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        principal.getAttributes().forEach((k, v) -> {
            log.info(k + " : " + v);
        });
        return Collections.singletonMap("name", principal.getAttribute("name"));
    }

    @GetMapping("/api/token")
    public String getAccessToken(Authentication authentication) {
        OAuth2AuthorizedClient authorizedClient = authorizedClientService.loadAuthorizedClient(
                "github", authentication.getName());

        if (authorizedClient != null && authorizedClient.getAccessToken() != null) {
            return "Access Token: " + authorizedClient.getAccessToken().getTokenType().getValue() +
                    "  value: " + authorizedClient.getAccessToken().getTokenValue()
                    +" scopes: " + authorizedClient.getAccessToken().getScopes();
        }

        return "No token found!";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/";
    }

}


