package com.loan_management_system_notifications.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loan_management_system_notifications.dto.request.EmailRequest;
import com.loan_management_system_notifications.services.NotificationServices;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    @Autowired
    private NotificationServices notificationServices;

    @PostMapping("/send-mail")
    public ResponseEntity<String> sendMail(
            @RequestBody EmailRequest request) {

        notificationServices.sendMail(
                request.getTo(),
                request.getSubject(),
                request.getBody()
        );

        return ResponseEntity.ok("Mail sent successfully");
    }
}
