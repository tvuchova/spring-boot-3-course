package com.elsys.demo.solid.dependencyInversion;

public class SmsService implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS sent with Message=" + message);
    }
}
