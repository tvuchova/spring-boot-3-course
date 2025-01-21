package com.example.spring_boot_mapstruct.dto;

import lombok.Data;



import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BookDTO implements Serializable{

    private UUID id;


    private String name;


    private String author;


    private LocalDateTime publishedDate;

    private UUID libraryId;
}
