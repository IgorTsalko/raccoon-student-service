package com.raccoon.learnapp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.raccoon.learnapp")
@EntityScan("com.raccoon.learnapp")
public class RaccoonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaccoonApplication.class, args);
    }
}
