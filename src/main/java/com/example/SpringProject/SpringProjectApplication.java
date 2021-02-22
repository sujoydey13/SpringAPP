package com.example.SpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(SpringProjectApplication.class, args);
	}

}
