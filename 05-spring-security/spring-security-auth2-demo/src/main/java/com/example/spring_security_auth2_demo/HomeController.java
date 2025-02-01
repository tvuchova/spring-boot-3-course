package com.example.spring_security_auth2_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;


@Slf4j
@RestController
public class HomeController {

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
}
