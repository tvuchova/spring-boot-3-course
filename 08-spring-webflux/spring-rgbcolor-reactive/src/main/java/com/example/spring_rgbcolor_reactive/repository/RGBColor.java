package com.example.spring_rgbcolor_reactive.repository;


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
