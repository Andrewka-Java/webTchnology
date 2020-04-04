package com.webtechnology;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.webtechnology.*")
@SpringBootApplication
public class ApplicationWS {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationWS.class, args);
    }
}
