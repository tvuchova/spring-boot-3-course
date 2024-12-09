package com.elsys.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping("/api/foos/{id}")
    public String addFoo(@PathVariable String id, @RequestBody FooRequest fooRequest) {
        return "Path ID: " + id + ", Body ID: " + fooRequest.getId() + ", Name: " + fooRequest.getName();
    }
}
