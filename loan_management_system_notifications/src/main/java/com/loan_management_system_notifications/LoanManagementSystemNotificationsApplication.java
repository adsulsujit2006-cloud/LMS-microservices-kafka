package com.loan_management_system_notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoanManagementSystemNotificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementSystemNotificationsApplication.class, args);
	}

}
