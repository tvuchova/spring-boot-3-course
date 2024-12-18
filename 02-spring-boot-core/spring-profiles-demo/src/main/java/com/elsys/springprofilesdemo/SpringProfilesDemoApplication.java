package com.elsys.springprofilesdemo;

import com.elsys.springprofilesdemo.mail.MailSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringProfilesDemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringProfilesDemoApplication.class, args);
        MailSender bean = context.getBean("mailSender", MailSender.class);
        bean.send("ss", "ss", "ss");

    }

}
