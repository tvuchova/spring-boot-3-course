package com.elsys.demo.solid.dependencyInversion;

public class EmailService implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email sent with Message=" + message);
    }
}
