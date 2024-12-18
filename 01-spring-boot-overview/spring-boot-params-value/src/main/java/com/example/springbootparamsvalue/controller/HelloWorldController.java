package com.example.springbootparamsvalue.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Value("${person.name}")
    private String name;
    @Value("${person.age}")
    private int age;

    @GetMapping("/hello")
    public String hello() {
        return "Hello, " + name;
    }
}
