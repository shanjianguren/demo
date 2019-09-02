package com.zhao.cloud.erueka1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableAutoConfiguration
public class Eureka1Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka1Application.class,args);
    }
}
