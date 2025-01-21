package com.example.spring_boot_mapstruct.dto.mapper;


import com.example.spring_boot_mapstruct.dao.entity.Library;
import com.example.spring_boot_mapstruct.dto.LibraryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", uses = {BookMapper.class})
public interface LibraryMapper  {

    @Mapping(source = "books", target = "bookDTOs")
    LibraryDTO toDto(final Library library);

    Library toEntity(final LibraryDTO libraryDTO);

    default Library fromId(final UUID id) {

        if (id == null) {
            return null;
        }

        final Library library=new Library();

        library.setId(id);

        return library;
    }

}
