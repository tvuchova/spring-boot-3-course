package com.example.springbootstudentcrud.repository;

import com.example.springbootstudentcrud.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
