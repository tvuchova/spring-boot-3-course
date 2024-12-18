package com.elsys.springbootopenapi.repository;

import com.elsys.springbootopenapi.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    User addUser(User user);
    Optional<User> updateUser(int id, String newName);
    boolean deleteUser(int id);

}
