package com.challenge.gmh.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * The API Gateway main class.
 *
 */
@SpringBootApplication
@EnableEurekaClient // Para que este ms sea descubierto por eureka
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
