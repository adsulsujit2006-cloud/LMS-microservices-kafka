package com.loan_management_system_notifications.services;

public interface NotificationServices {

    void sendMail(String to, String subject, String body);

}
