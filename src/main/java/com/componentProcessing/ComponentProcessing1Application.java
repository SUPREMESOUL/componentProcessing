package com.componentProcessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients


public class ComponentProcessing1Application {

	public static void main(String[] args) {
		SpringApplication.run(ComponentProcessing1Application.class, args);
	}

}
