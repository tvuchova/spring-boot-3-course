package com.example.spring_boot_mapstruct.dto;

import lombok.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

@Data
public class LibraryDTO implements Serializable {

    private UUID id;


    private String name;


    private List<BookDTO> bookDTOs = new ArrayList<>();

}
