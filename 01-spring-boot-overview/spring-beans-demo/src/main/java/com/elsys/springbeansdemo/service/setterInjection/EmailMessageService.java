package com.elsys.springbeansdemo.service.setterInjection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EmailMessageService implements MessageService {
    @Override
    public void sendMessage(String message, String receiver) {
        log.info("Email sent to " + receiver + " with Message=" + message);
    }
}
