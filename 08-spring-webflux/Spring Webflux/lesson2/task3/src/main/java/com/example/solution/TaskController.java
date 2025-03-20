package com.example.solution;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/*
@RestController
@RequestMapping("/api")
public class TaskController {
    // TODO: Implement this method to return a Flux<Integer>
    @GetMapping("/primes")
    public Flux<Integer> getPrimeNumbers(@RequestParam(name="start") Integer start, @RequestParam(name="end") Integer end) {
        return findPrimesInRange(start, end);
    }

    public Flux<Integer> findPrimesInRange(int start, int end) {
        return Flux.range(start, end - start + 1)
                .filter(this::isPrime);
    }


    public boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
*/
