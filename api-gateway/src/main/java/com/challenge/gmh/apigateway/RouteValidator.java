package com.challenge.gmh.apigateway;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

/**
 * path's validator.
 * Some endpoints need to be unprotected i.e., to allow invocation without a token
 * (e.g.: login URL, health check URL, etc.).
 *
 * We will add them to the below list :
 */
@Component
public class RouteValidator {

    public static final List<String> unprotectedURLs = List.of("/api/login");

    public Predicate<ServerHttpRequest> isSecured =
            request -> unprotectedURLs.stream().noneMatch(uri -> request.getURI().getPath().contains(uri));
}