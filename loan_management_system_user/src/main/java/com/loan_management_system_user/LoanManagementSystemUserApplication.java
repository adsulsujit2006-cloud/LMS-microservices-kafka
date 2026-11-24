package com.loan_management_system_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class LoanManagementSystemUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementSystemUserApplication.class, args);
	}

}
