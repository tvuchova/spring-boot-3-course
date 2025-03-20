

### Task: Create a Reactive Endpoint

Implement a **Spring WebFlux controller** that returns a Flux of strings.

#### Requirements:
- Create a REST API that returns a Mono<User>.
- Create an endpoint that streams a Flux<User>.
- Implement WebClient to consume a reactive service.


@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable String id) {
        return Mono.just(new User(id, "John Doe"));
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return Flux.just(new User("1", "Alice"), new User("2", "Bob"));
    }
}
**Run tests to verify your solution!**

