package org.elsys.springcarautopark.user.service;

import lombok.extern.slf4j.Slf4j;
import org.elsys.springcarautopark.user.model.ROLE;
import org.elsys.springcarautopark.user.model.Roles;
import org.elsys.springcarautopark.user.model.User;
import org.elsys.springcarautopark.user.model.dto.UserDto;
import org.elsys.springcarautopark.user.model.dto.UserMapper;
import org.elsys.springcarautopark.user.repository.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    //private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper/*, PasswordEncoder passwordEncoder*/) {
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void addUser(User user) {
        log.info("Adding user: {}", user);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRoles() == null) {

            user.setRoles(new Roles(1L,ROLE.USER, List.of(user)));
        }
        userRepository.save(user);
    }

    public List<UserDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto).toList();
    }

    public UserDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }
}
