package com.elsys.springbootcommandline;

import com.elsys.springbootcommandline.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Slf4j
public class SpringBootCommandLineApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootCommandLineApplication.class, args);
    }


}
