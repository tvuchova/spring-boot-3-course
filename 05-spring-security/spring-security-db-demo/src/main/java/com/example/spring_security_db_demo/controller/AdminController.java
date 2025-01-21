package com.example.spring_security_db_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public  String getAdminDetails () {
        return "Here are the admin details from the DB";
    }

}
