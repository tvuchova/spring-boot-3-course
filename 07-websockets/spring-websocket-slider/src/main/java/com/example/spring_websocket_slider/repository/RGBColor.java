package com.example.spring_websocket_slider.repository;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@Data
public class RGBColor {
    private int red;
    private int green;
    private int blue;
    private Instant timestamp = Instant.now();
}
