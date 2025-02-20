package com.example.spring_boot_unit_tests.service;


import com.example.spring_boot_unit_tests.model.User;
import com.example.spring_boot_unit_tests.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(long id, String newName) {
        userRepository.updateUser(id, newName);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteUser(id);
    }
}
