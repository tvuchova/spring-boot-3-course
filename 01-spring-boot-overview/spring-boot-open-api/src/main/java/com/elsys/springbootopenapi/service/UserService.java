package com.elsys.springbootopenapi.service;

import com.elsys.springbootopenapi.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User addUser(User user);
    User updateUser(int id, String newName);
    boolean deleteUser(int id);


}
