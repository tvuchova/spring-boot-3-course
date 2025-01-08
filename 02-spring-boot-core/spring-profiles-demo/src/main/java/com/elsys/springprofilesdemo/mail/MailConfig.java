package com.elsys.springprofilesdemo.mail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MailConfig {
    @Profile("dev")
    @Bean(name = "mailSender")
    public MailSender mockMailSender() {

        return new MockedMailSender();
    }
    @Profile("!dev")
    @Bean(name = "mailSender")
    public MailSender smtpMailSender() {

        return new SmtpMailSender();
    }
}
