package com.example.spring_security_db_demo.config;

import com.example.spring_security_db_demo.model.User;
import com.example.spring_security_db_demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User name = userRepository.findByName(username);
        if (name == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(name.getRoles().getRoleName().name()));
        return org.springframework.security.core.userdetails.User.builder()
                .username(name.getName())
                .password(name.getPassword())
                .authorities(authorities)
                .build();
    }
}
