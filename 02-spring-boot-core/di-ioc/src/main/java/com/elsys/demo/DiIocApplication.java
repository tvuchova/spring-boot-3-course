package com.elsys.demo;


import com.elsys.demo.di.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@Slf4j
@SpringBootApplication
public class DiIocApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DiIocApplication.class, args);
		ItemService itemService = context.getBean("itemServiceImpl", ItemService.class);
		log.info(itemService.findAll().toString());
	}

}
