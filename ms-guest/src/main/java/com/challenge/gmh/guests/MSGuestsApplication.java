package com.challenge.gmh.guests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@EnableEurekaClient // No es necesaria esta anotación, siempre y cuando se agrege la dependencia de eureka-discovery
@SpringBootApplication
public class MSGuestsApplication {
    public static void main(String[] args) {
        SpringApplication.run(MSGuestsApplication.class, args);
    }
}
