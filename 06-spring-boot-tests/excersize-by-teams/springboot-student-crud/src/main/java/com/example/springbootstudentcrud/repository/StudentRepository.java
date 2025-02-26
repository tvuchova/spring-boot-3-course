package com.example.springbootstudentcrud.repository;

import com.example.springbootstudentcrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findByName(String name);

}
