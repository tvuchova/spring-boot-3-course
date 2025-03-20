package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureWebTestClient
public class Tests {

    WebTestClient webTestClient;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setup() {
        webTestClient = WebTestClient.bindToServer().baseUrl("http://localhost:" + port).build();
    }

    @Test
    public void testFindPrimesInRange() {
        // Send GET request to /primes with start=1 and end=10
        webTestClient.get()
                .uri("/api/primes?start=1&end=10")
                .exchange()
                .expectStatus().isOk()  // Expect 200 OK response
                .expectBodyList(Integer.class)  // Expect a List of Integers in response body
                .value(primes -> {
                    // Check if the response contains only prime numbers between 1 and 10
                    List<Integer> primeNumbers = List.of(2, 3, 5, 7);
                    assertEquals(primes, primeNumbers);
                });
    }

    @Test
    public void testNoPrimesInRange() {
        // Send GET request to /primes with start=20 and end=20
        webTestClient.get()
                .uri("/api/primes?start=20&end=20")
                .exchange()
                .expectStatus().isOk()  // Expect 200 OK response
                .expectBodyList(Integer.class)  // Expect a List of Integers in response body
                .value(primes -> assertEquals(primes.size(), 0));  // Expect an empty list
    }

    @Test
    public void testFindPrimesInLargeRange() {
        // Send GET request to /primes with start=50 and end=100
        webTestClient.get()
                .uri("/api/primes?start=50&end=100")
                .exchange()
                .expectStatus().isOk()  // Expect 200 OK response
                .expectBodyList(Integer.class)  // Expect a List of Integers in response body
                .value(primes -> {
                    // Check the prime numbers between 50 and 100
                    List<Integer> expectedPrimes = List.of(53, 59, 61, 67, 71, 73, 79, 83, 89, 97);
                    assertEquals(primes, expectedPrimes);
                });
    }

    @Test
    public void testInvalidQueryParameters() {
        // Send GET request with non-integer query params
        webTestClient.get()
                .uri("/api/primes?start=abc&end=xyz")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);  // Expect 400 Bad Request due to invalid parameters
    }
}
