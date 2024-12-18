package com.elsys.demo.solid.dependencyInversion;

public class Main {
    public static void main(String[] args) {
        Notification notification = new EmailService();
        notification.send("Hello");

        Notification notification2 = new SmsService();
        notification2.send("Hello");
    }

}
