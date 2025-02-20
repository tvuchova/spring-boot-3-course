package com.example.spring_boot_unit_tests.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {
    @GetMapping("/apidoc")
    public String swaggerUI() {
        return "redirect:/swagger-ui.html";
    }

}
