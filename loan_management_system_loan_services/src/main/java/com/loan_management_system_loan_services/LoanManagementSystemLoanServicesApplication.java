package com.loan_management_system_loan_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoanManagementSystemLoanServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementSystemLoanServicesApplication.class, args);
	}

}
