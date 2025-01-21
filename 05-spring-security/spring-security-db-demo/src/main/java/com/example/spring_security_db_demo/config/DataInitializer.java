package com.example.spring_security_db_demo.config;

import com.example.spring_security_db_demo.model.ROLE;
import com.example.spring_security_db_demo.model.Roles;
import com.example.spring_security_db_demo.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.logging.Logger;

import static com.example.spring_security_db_demo.model.ROLE.ADMIN;
import static com.example.spring_security_db_demo.model.ROLE.USER;

@Component
@Slf4j
public class DataInitializer  {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    @Transactional
    public void inizializeRoles() throws Exception {
        if (roleRepository.findByRoleName(ADMIN).isEmpty()) {
            Roles adminRole = new Roles(null, ADMIN, new ArrayList<>());
            roleRepository.save(adminRole);
            log.info("Saved role: {}", ROLE.ADMIN);
        }
        if (roleRepository.findByRoleName(ROLE.USER).isEmpty()) {
            Roles userRole = new Roles(null, ROLE.USER, new ArrayList<>());
            roleRepository.save(userRole);
            log.info("Saved role: {}", ROLE.USER);
        }
    }
}
