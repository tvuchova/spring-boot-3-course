package com.example.solution;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
@RestController
public class WebClientController {
    // TODO: Implement this method to return a Flux<Integer>
    private final WebClientService webClientService;

    public WebClientController(WebClientService webClientService) {
        this.webClientService = webClientService;
    }


    @GetMapping("/api/users/{id}")
    public Mono<User> getUserById(@PathVariable(name = "id") String id) {
        return webClientService.getUserById(id);
    }

    // Endpoint to fetch all users
    @GetMapping("/api/users")
    public Flux<User> getAllUsers() {
        return webClientService.getAllUsers();
    }
}
*/
