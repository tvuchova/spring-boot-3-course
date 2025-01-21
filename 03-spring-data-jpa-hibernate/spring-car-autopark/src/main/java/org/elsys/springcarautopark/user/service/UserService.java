package org.elsys.springcarautopark.user.service;

import org.elsys.springcarautopark.user.model.User;
import org.elsys.springcarautopark.user.model.dto.UserDto;

import java.util.List;


public interface UserService {

    void addUser(User user);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id) ;
}
