package com.example.spring_boot_unit_tests.controller;


import com.example.spring_boot_unit_tests.model.User;
import com.example.spring_boot_unit_tests.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(description = "User API", name = "User Services")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @Operation(summary = "Returns all users.", tags = {"User",},
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Returns all users",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)))
            })
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/users")
    @Operation(summary = "Register a new user",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "Returns the registered user",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = User.class)))
            })
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable int id, @RequestParam String newName) {
        userService.updateUser(id, newName);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
