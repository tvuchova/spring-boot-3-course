package org.elsys.springcarautopark.user.service;

import org.elsys.springcarautopark.user.model.User;

import java.util.List;


public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id) ;
}
