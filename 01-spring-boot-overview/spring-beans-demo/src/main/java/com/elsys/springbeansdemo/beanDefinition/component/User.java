package com.elsys.springbeansdemo.beanDefinition.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class User {
    private String name;
    private String email;
    private String password;
}
