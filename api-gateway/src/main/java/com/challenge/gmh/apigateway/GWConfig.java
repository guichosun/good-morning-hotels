package com.challenge.gmh.apigateway;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * Yhe main's config.
 * Here I've written the CircuitBraker config.
 */
@Configuration
public class GWConfig {

/*	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		// adding 2 rotes to first microservice as we need to log request body if method is POST
		return builder.routes()
				.route("first-microservice",r -> r.path("/first")
						.and().method("POST")
						.and().readBody(Student.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
						.uri("http://localhost:8081"))
				.route("first-microservice",r -> r.path("/first")
						.and().method("GET").filters(f-> f.filters(authFilter))
						.uri("http://localhost:8081"))
				.route("second-microservice",r -> r.path("/second")
						.and().method("POST")
						.and().readBody(Company.class, s -> true).filters(f -> f.filters(requestFilter, authFilter))
						.uri("http://localhost:8082"))
				.route("second-microservice",r -> r.path("/second")
						.and().method("GET").filters(f-> f.filters(authFilter))
						.uri("http://localhost:8082"))
				.route("auth-server",r -> r.path("/login")
						.uri("http://localhost:8088"))
				.build();
	}
*/
	/**
	 * A CircuitBraker bean
	 *
	 * @return
	 */
	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer(){
		return factory -> factory.configureDefault(id -> {
			return new Resilience4JConfigBuilder(id)
					// La configuración del Circuit break
					.circuitBreakerConfig(CircuitBreakerConfig.custom()
// Tamaño de la ventana deslizante. Numero de peticiones de falla a un ms
							.slidingWindowSize(10)
// Es el umbral de fallas, es un porcentaje, o sea que cuando sean 5 peticiones las que falle se abre el circuito
							.failureRateThreshold(50) // El 50% de peticiones de falla
// La dureción de espera en lo que está en estado abierto
							.waitDurationInOpenState(Duration.ofSeconds(10L))
// Numero de peticiones permitidas en lo que estña en estado semi-abierto. Se haran 5 peticiones de prueba para saber si ya está arriba el ms
							.permittedNumberOfCallsInHalfOpenState(5)
// Es el porcentaje de llamadas lentas, Es decir el 50 porciento de las peticiones que se concideren lentas.
							.slowCallRateThreshold(50)
// El tiempo en la que una llamada se considerara lenta
							.slowCallDurationThreshold(Duration.ofSeconds(2L))
							.build())
					.timeLimiterConfig(TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3L)).build())
					.build();
		});
	}
}