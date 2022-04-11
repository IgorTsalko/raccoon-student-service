package com.raccoon.learnapp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication(scanBasePackages = "com.raccoon.learnapp")
@EntityScan("com.raccoon.learnapp")
public class RaccoonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RaccoonApplication.class, args);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages/error-patterns");
        return messageSource;
    }
}
