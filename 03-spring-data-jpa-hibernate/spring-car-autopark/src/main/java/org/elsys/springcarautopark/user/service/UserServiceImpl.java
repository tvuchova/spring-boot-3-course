package org.elsys.springcarautopark.user.service;

import lombok.extern.slf4j.Slf4j;
import org.elsys.springcarautopark.user.model.ROLE;
import org.elsys.springcarautopark.user.model.Roles;
import org.elsys.springcarautopark.user.model.User;
import org.elsys.springcarautopark.user.repository.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository/*, PasswordEncoder passwordEncoder*/) {
        this.userRepository = userRepository;
        //this.passwordEncoder = passwordEncoder;
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

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
