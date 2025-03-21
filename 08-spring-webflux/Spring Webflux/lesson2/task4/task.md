

### Task: Create a Reactive Endpoint

Implement a **Spring WebFlux controller** that uses Webclient.

#### Requirements:
- Create a REST API that returns a Mono<User> calling https://jsonplaceholder.typicode.com get users/1.
- Create an endpoint that streams a Flux<User> callin api get users/.
- Implement WebClient to consume a reactive service.

**Run tests to verify your solution!**

In Spring Boot, WebClient is a reactive web client used to make HTTP requests to external services. It is part of Spring WebFlux and is the non-blocking alternative to RestTemplate.
You need to create webClientConfig
```java
@Configuration
public class WebClientConfig {
@Bean
public WebClient webClient() {
    return WebClient.builder()
           .baseUrl("https://api.example.com")
           .build();
  }
}
```


You can make post request with:

```java

public void sendData(Object requestBody) {
Mono<String> response = webClient.post()
     .uri("/submit")
     .bodyValue(requestBody)
     .retrieve()
     .bodyToMono(String.class);

    response.subscribe(System.out::println);
}
```

WebClient is:
1. Asynchronous & Non-blocking – Handles high-throughput requests efficiently.
2. Supports Streaming – Works well with large datasets and streaming APIs.
3. Flexible Configuration – Easily configurable with timeouts, headers, and interceptors.

If you're using OAuth2, integrate with Spring Security:(spring-boot-starter-oauth2-client)

```java
@Service
public class OAuth2WebClientService {
    private final WebClient webClient;
    private final OAuth2AuthorizedClientService authorizedClientService;

    public OAuth2WebClientService(WebClient.Builder webClientBuilder, OAuth2AuthorizedClientService authorizedClientService) {
        this.webClient = webClientBuilder.baseUrl("https://api.example.com").build();
        this.authorizedClientService = authorizedClientService;
    }

    public String fetchProtectedData(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(), authentication.getName());

        String accessToken = client.getAccessToken().getTokenValue();

        return webClient.get()
                .uri("/protected-endpoint")
                .headers(headers -> headers.setBearerAuth(accessToken))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
```