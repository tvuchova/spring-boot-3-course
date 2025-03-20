package main.java.com.example;

import com.example.solution.User;
import com.example.solution.WebClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {
    // TODO: Implement this method to return a Flux<Integer>

    @GetMapping("/api/users/{id}")
    public Mono<User> getUserById(@PathVariable(name = "id") String id) {
        return null;
    }

    @GetMapping("/api/users")
    public Flux<User> getAllUsers() {
        return null;
    }
}
