package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import com.example.solution.User;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes ={main.java.com.example.SpringReactiveApplication.class})
public class Tests {

  @LocalServerPort
  private int port;

  @Autowired
  private WebClient.Builder webClientBuilder;
  @Test
  public void testGetUserById() {
    WebClient webClient = webClientBuilder.baseUrl("http://localhost:" + port).build();

    Mono<User> userMono = webClient.get()
            .uri("/api/users/1")
            .retrieve()
            .bodyToMono(User.class);

    StepVerifier.create(userMono)
            .expectNextMatches(user -> user.getId() == 1 && "Leanne Graham".equals(user.getName()))
            .verifyComplete();

  }

  @Test
  public void testGetAllUsers() {
    WebClient webClient = webClientBuilder.baseUrl("http://localhost:" + port).build();

    var usersFlux = webClient.get()
            .uri("/api/users")
            .retrieve()
            .bodyToFlux(User.class);

    StepVerifier.create(usersFlux)
            .expectNextCount(10) // We know jsonplaceholder returns 10 users
            .verifyComplete();
  }
}
