package com.example.web_sockets_stomp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

//will listen for messages from clients and broadcust to subscribers
@Controller
public class TestController {

    @MessageMapping("/chat") // Clients send messages here (/app/chat)
    @SendTo("/topic/messages") // Messages are broadcast to all subscribers
    public TestMessage sendMessage(TestMessage message) {
        message.setMessage("Server received: " + message.getMessage());
        return message;
    }
}
