package com.elsys.springbeansdemo.service.constructorInjection;

import com.elsys.springbeansdemo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserService {
    public String getUser(UserRepository userRepository) {
        log.info(userRepository.getRepository());
        return "User";
    }
}
