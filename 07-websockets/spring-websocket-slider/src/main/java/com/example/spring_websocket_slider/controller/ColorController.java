package com.example.spring_websocket_slider.controller;

import com.example.spring_websocket_slider.repository.RGBColor;
import com.example.spring_websocket_slider.repository.RGBColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ColorController {
    private final RGBColorRepository repository;

    @MessageMapping("/color")
    @SendTo("/topic/color")
    RGBColor updateColor(RGBColor color) {
        repository.save(color);
        return color;
    }
}

