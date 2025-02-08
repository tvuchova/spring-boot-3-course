package org.elsys.springmvchello.controller;

import lombok.AllArgsConstructor;
import org.elsys.springmvchello.model.User;
import org.elsys.springmvchello.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC with Thymeleaf!");
        return "home";
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam(name = "name", required = false, defaultValue = "User") String name, Model model) {
        User user = userService.getUserByName(name);
        model.addAttribute("user", user);
        return "welcome";
    }
}
