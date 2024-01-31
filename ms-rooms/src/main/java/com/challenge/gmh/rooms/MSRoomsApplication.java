package com.challenge.gmh.rooms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Rooms app.
 */
@SpringBootApplication
@EnableMongoRepositories // Para habilitar los repositories de mongo
@EnableEurekaClient // No es necesaria esta anotación, siempre y cuando se agrege la dependencia de eureka-discovery
public class MSRoomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MSRoomsApplication.class, args);
	}

}
