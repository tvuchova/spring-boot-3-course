package com.example.spring_rgbcolor_reactive.service;

import com.example.spring_rgbcolor_reactive.repository.RGBColor;
import com.example.spring_rgbcolor_reactive.repository.RGBColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RGBColorService {
    private final RGBColorRepository repository;

    public Mono<RGBColor> saveColor(RGBColor color) {
        return repository.save(color);
    }
}
