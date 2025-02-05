package com.example.spring_security_db_demo.config;

import com.example.spring_security_db_demo.model.Roles;
import com.example.spring_security_db_demo.model.User;
import com.example.spring_security_db_demo.repository.RoleRepository;
import com.example.spring_security_db_demo.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static com.example.spring_security_db_demo.model.ROLE.ADMIN;
import static com.example.spring_security_db_demo.model.ROLE.USER;

@Component
@Slf4j
public class UserInizializer {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    public UserInizializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    @Transactional
    public void initializeUsers() {
        if (userRepository.count() == 0) {
            Roles adminRole = roleRepository.findByRoleName(ADMIN)
                    .orElseThrow(() -> new RuntimeException("ADMIN role not found"));
            Roles userRole = roleRepository.findByRoleName(USER)
                    .orElseThrow(() -> new RuntimeException("User role not found"));

            User adminUser = new User(null, "admin", "admin@example.com", passwordEncoder.encode("admin"), adminRole);
            userRepository.save(adminUser);

            User normalUser = new User(null, "user", "user@example.com", passwordEncoder.encode("user"), userRole);
            userRepository.save(normalUser);
            log.info("Saved first admin user: {}", adminUser.getEmail());
        }
    }
}

