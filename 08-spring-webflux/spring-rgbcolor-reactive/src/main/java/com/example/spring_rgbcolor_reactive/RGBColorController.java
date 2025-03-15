package com.example.spring_rgbcolor_reactive;

import com.example.spring_rgbcolor_reactive.repository.RGBColor;
import com.example.spring_rgbcolor_reactive.repository.RGBColorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//not needed
@RestController
@RequestMapping("/colors")
public class RGBColorController {

    private final RGBColorRepository repository;

    public RGBColorController(RGBColorRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Mono<RGBColor> saveColor(@RequestBody RGBColor color) {
        return repository.save(color);
    }

    @GetMapping
    public Flux<RGBColor> getAllColors() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<RGBColor> getColorById(@PathVariable String id) {
        return repository.findById(id);
    }
}
