package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class TaskController {
    // TODO: Implement this method to return a Flux<Integer>
    @GetMapping("/primes")
    public Flux<Integer> getPrimeNumbers(@RequestParam(name="start") Integer start, @RequestParam(name="end") Integer end) {
        return null;//put your solution here
    }


}
