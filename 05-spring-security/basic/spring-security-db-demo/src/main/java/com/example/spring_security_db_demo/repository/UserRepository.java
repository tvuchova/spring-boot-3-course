package com.example.spring_security_db_demo.repository;


import com.example.spring_security_db_demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    List<User> findAll();

    Optional<User> findByEmail(String username);

    User findByName(String username);

}
