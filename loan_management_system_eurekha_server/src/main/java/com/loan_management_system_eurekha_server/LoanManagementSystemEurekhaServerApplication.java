package com.loan_management_system_eurekha_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class LoanManagementSystemEurekhaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanManagementSystemEurekhaServerApplication.class, args);
	}

}
