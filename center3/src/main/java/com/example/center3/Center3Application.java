package com.example.center3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Center3Application {

    public static void main(String[] args) {
        SpringApplication.run(Center3Application.class, args);
    }

}
