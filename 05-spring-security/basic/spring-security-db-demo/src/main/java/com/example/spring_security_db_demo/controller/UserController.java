package com.example.spring_security_db_demo.controller;

import com.example.spring_security_db_demo.model.ROLE;
import com.example.spring_security_db_demo.model.Roles;
import com.example.spring_security_db_demo.repository.RoleRepository;
import com.example.spring_security_db_demo.repository.UserRepository;
import com.example.spring_security_db_demo.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.example.spring_security_db_demo.model.ROLE.ADMIN;
import static com.example.spring_security_db_demo.model.ROLE.USER;

@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        log.info("Registering user: {}", user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<Roles> roles = roleRepository.findByRoleName(ROLE.USER);
        if (roles.isPresent()) {
            user.setRoles(roles.get());
        } else {//error
        }

        userRepository.save(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);

    }
}
