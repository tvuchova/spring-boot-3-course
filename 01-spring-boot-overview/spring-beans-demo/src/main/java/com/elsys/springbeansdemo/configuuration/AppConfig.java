package com.elsys.springbeansdemo.configuuration;


import com.elsys.springbeansdemo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    UserRepository userRepository() {
        return new UserRepository();
    }
}
