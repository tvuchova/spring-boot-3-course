package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWebTestClient
public class Tests {

 WebTestClient webTestClient;

  @LocalServerPort
  private int port;

  @BeforeEach
  void setup() {webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
  }
  @Test
  public void testGetMessages() {

    webTestClient.get().uri("/api/messages")
            .exchange()
           .expectStatus().isOk()
            .expectBodyList(String.class)
           .contains("Hello");
  }
}
