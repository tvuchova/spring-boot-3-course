package com.example.spring_boot_unit_tests.service;



import com.example.spring_boot_unit_tests.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User addUser(User user);
    void updateUser(long id, String newName);
    void deleteUser(long id);


}
