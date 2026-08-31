package com.loan_management_system_user.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.loan_management_system_user.dto.request.EmailRequest;

@FeignClient(name = "LMS-NOTIFICATIONS", url = "${notification.service.url}")
public interface NotificationClient {
	@PostMapping("/api/v1/notification/send-mail")
	String sendMail(@RequestBody EmailRequest request);
}