package com.example.spring_security_db_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringSecurityDbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbDemoApplication.class, args);
	}

}
