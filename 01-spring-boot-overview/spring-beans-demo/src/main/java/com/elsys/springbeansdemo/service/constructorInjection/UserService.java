package com.elsys.springbeansdemo.service.constructorInjection;

import com.elsys.springbeansdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUser() {
        log.info(userRepository.getRepository());
        return "User";
    }
}
