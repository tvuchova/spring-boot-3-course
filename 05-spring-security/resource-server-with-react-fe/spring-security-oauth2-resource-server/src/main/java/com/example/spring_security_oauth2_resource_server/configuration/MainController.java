package com.example.spring_security_oauth2_resource_server.configuration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/public")
    public String homePage() {
        return "Hello from Spring boot app";
    }

    @GetMapping("/private")
    public String privateRoute() {
        return "Private Route";
    }
}
