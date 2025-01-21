package com.example.spring_boot_mapstruct.dao.repository;


import com.example.spring_boot_mapstruct.dao.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ILibraryRepository extends JpaRepository<Library, UUID> {

}
