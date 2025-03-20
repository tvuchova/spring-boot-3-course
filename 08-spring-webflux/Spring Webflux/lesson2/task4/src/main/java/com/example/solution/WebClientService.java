package com.example.solution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class WebClientService {
    private final WebClient.Builder webClientBuilder;

    @Autowired
    public WebClientService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    // Fetches a single user by ID
    public Mono<User> getUserById(String id) {
        return webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com")
                .build()
                .get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }

    // Fetches all users (as a Flux stream)
    public Flux<User> getAllUsers() {
        return webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com")
                .build()
                .get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(User.class);
    }
}
