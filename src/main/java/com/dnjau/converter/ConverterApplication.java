package com.dnjau.converter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)  // Force CGLIB-based proxies
public class ConverterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConverterApplication.class, args);
    }

}
