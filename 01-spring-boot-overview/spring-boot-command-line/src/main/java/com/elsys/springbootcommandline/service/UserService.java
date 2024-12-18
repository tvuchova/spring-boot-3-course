package com.elsys.springbootcommandline.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<String, String> users = new HashMap<>();

    public void addUser(String username, String email) {
        if (users.containsKey(username)) {
            throw new IllegalArgumentException("User already exists: " + username);
        }
        users.put(username, email);
    }

    public void listUsers() {
        if (users.isEmpty()) {
            System.out.println("No users found.");
        } else {
            System.out.println("Registered users:");
            users.forEach((username, email) ->
                    System.out.printf("Username: %s, Email: %s%n", username, email));
        }
    }
}
