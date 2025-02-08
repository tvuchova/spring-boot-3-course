package org.elsys.springmvchello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringMvcHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcHelloApplication.class, args);
    }

}
