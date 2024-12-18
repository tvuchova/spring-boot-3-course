package com.elsys.springbootopenapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class User {
    private final int id;
    private  String name;

}
