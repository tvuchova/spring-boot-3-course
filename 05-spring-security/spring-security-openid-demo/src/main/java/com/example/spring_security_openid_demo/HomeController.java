package com.example.spring_security_openid_demo;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Hello, home!";
    }

    @GetMapping("/secured")
    public String secured() {
        return "Hello, secured!";
    }

    @GetMapping("/user")
    public OidcUser getUser(@AuthenticationPrincipal OidcUser user) {
        return user;
    }
}
