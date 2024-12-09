package com.elsys.springbeansdemo.service.setterInjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageProcessor {
    private MessageService messageService;

    // Setter for dependency injection
    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void processMessage(String message, String receiver) {
        if (messageService == null) {
            throw new IllegalStateException("MessageService not set");
        }
        messageService.sendMessage(message, receiver);
    }
}
