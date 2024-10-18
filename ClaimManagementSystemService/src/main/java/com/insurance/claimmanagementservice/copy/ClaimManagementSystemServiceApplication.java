package com.insurance.claimmanagementservice.copy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class ClaimManagementSystemServiceApplication {

	public static void main(String[] args) {
		System.out.println("This is claim management system");
		SpringApplication.run(ClaimManagementSystemServiceApplication.class, args);
	}

}
