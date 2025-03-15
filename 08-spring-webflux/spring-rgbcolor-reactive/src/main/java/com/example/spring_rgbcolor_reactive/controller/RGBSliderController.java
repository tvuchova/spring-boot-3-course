package com.example.spring_rgbcolor_reactive.controller;

import com.example.spring_rgbcolor_reactive.repository.RGBColor;
import com.example.spring_rgbcolor_reactive.service.RGBColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class RGBSliderController {
    private final RGBColorService colorService;

    @MessageMapping("/color")  // Client sends messages to "/app/color"
    @SendTo("/topic/color")   // Broadcasts to all subscribers
    public Mono<RGBColor> updateColor(RGBColor color) {
        return colorService.saveColor(color);
    }
}
