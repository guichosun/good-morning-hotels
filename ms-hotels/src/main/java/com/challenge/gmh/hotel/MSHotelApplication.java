package com.challenge.gmh.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * Tha main point of the hotels app.
 */
@SpringBootApplication
@EnableMongoRepositories("com.challenge.gmh.hotel.repository") // Para habilitar los repositories de mongo
@EnableFeignClients
//@RibbonClient("ms-rooms") No es  necesario si se usa eureka
@EnableEurekaClient // No es necesaria esta anotación, siempre y cuando se agrege la dependencia de eureka-discovery
public class MSHotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MSHotelApplication.class, args);
	}

}
