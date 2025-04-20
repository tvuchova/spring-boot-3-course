package com.example.spring_boot_kafka.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PracticalAdvice(@JsonProperty("message") String message,
                       @JsonProperty("identifier") int identifier) {
}
