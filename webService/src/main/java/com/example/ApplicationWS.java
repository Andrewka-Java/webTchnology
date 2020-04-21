package com.example;

import com.example.endpoint.config.WSConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.*")
@SpringBootApplication(scanBasePackages = "com.example.*")
public class ApplicationWS {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationWS.class, args);
    }
}
