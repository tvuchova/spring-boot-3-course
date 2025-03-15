package com.example.spring_rgbcolor_reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RGBColorRepository extends ReactiveMongoRepository<RGBColor, String> {
    Flux<RGBColor> findByRed(int red);
}
