package com.elsys.demo.dependency;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String name;
    private String description;
    private double price;

}
