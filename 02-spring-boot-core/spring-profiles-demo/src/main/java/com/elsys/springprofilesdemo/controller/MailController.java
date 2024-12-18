package com.elsys.springprofilesdemo.controller;

import com.elsys.springprofilesdemo.mail.MailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    private MailSender mailSender;

    public MailController(MailSender smtp) {
        this.mailSender = smtp;
    }

    @RequestMapping("/mail")
    public String mail() {

        mailSender.send("mail@example.com", "A test mail", "Body of the test mail");

        return "Mail sent";
    }
}
