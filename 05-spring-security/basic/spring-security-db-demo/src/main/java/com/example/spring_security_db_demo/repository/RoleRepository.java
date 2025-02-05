package com.example.spring_security_db_demo.repository;


import com.example.spring_security_db_demo.model.ROLE;
import com.example.spring_security_db_demo.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Optional<Roles> findByRoleName(ROLE name);
}
