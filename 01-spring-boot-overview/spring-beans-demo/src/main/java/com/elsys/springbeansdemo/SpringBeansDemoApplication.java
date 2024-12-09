package com.elsys.springbeansdemo;

import com.elsys.springbeansdemo.repository.UserRepository;
import com.elsys.springbeansdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class SpringBeansDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBeansDemoApplication.class, args);
        ExampleBean bean = context.getBean("exampleBean", ExampleBean.class);

       UserService userService = context.getBean("userService", UserService.class);
        log.info(userService.getUser(context.getBean("userRepository", UserRepository.class)));


    }
}
