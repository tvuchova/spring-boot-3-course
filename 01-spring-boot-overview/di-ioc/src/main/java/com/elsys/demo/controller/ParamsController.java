package com.elsys.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParamsController {
    @GetMapping("/api/foos")
    public String getFoos(@RequestParam String id) {
        return "ID: " + id;
    }

    @PostMapping("/api/foos")
    public String addFoo(@RequestBody FooRequest fooRequest) {
        return "ID: " + fooRequest.getId() + " Name: " + fooRequest.getName();
    }


}
