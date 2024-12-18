package com.elsys.springprofilesdemo.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;

@Slf4j
public class MockedMailSender implements MailSender {
    @Override
    public void send(String to, String subject, String body) {
        log.info("Sending mocked mail to " + to);
        log.info("Subject: " + subject);
        log.info("Body: " + body);
    }
}
