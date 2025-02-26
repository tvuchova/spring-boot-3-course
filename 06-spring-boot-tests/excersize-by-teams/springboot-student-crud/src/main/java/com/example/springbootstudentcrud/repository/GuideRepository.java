package com.example.springbootstudentcrud.repository;

import com.example.springbootstudentcrud.entity.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {
}
