package com.aos.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class HightEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(HightEurekaApplication.class, args);
	}
}
