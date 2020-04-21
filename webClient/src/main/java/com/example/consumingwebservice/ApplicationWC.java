package com.example.consumingwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.*")
public class ApplicationWC {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationWC.class, args);
	}

}
