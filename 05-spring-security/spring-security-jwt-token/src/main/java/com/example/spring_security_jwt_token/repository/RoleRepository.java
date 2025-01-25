package com.example.spring_security_jwt_token.repository;


import com.example.spring_security_jwt_token.model.ERole;
import com.example.spring_security_jwt_token.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
