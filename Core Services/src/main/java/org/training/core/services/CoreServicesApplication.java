package org.training.core.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CoreServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreServicesApplication.class, args);
    }

}
