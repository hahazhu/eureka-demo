package com.example.center2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Center2Application {

    public static void main(String[] args) {
        SpringApplication.run(Center2Application.class, args);
    }

}
