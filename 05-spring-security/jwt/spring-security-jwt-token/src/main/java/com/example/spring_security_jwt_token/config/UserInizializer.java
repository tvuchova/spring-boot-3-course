package com.example.spring_security_jwt_token.config;


import com.example.spring_security_jwt_token.model.ERole;
import com.example.spring_security_jwt_token.model.Role;
import com.example.spring_security_jwt_token.model.User;
import com.example.spring_security_jwt_token.repository.RoleRepository;
import com.example.spring_security_jwt_token.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;


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
            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("ADMIN role not found"));
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("User role not found"));

            User adminUser = new User(null, "admin", "admin@example.com", passwordEncoder.encode("admin"), Set.of(adminRole));
            userRepository.save(adminUser);

            User normalUser = new User(null, "user", "user@example.com", passwordEncoder.encode("user"), Set.of(userRole));
            userRepository.save(normalUser);
            log.info("Saved first admin user: {}", adminUser.getEmail());
        }
    }
}

