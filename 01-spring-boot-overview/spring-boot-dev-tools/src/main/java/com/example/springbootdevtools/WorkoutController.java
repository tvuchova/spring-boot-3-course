package com.example.springbootdevtools;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
    @GetMapping("/daily-workout")
    public String greet(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!"+ " Start Your Bring Sally Up Training Push ups!";
    }
}
