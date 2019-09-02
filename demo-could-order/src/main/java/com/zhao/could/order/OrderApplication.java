package com.zhao.could.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zhao")
public class OrderApplication {
    public static void main(String[] args) {
       SpringApplication.run(OrderApplication.class, args);
    }
}
