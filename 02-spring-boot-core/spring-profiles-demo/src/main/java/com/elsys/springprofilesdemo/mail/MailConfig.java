package com.elsys.springprofilesdemo.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MailConfig {
    //one bean for dev and one not
    @Bean(name = "mailSender")
    public MailSender mockMailSender() {

        return new MockedMailSender();
    }

    @Bean(name = "mailSender")
    public MailSender smtpMailSender() {

        return new SmtpMailSender();
    }
}
