package com.cg.bookingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
// @EnableFeignClients(<package where proxy interface are>)
@EnableFeignClients("com.cg.bookingservice.feignproxy")
public class BookingManagementRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingManagementRestApplication.class, args);
	}

	

}
