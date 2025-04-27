package com.example.hospital.controller.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public abstract class PersonDto {
    private Long id;
    private String name;
    private int age;
    private String EGN;


}
