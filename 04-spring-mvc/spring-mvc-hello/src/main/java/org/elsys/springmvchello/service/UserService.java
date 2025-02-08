package org.elsys.springmvchello.service;

import org.elsys.springmvchello.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUserByName(String name) {
        return new User(name, 30);
    }
}
