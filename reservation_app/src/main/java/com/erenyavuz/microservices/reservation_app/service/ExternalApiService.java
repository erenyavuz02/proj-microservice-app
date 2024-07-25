package com.erenyavuz.microservices.reservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.erenyavuz.microservices.reservation_app.dto.UserValidationResponse;
import com.erenyavuz.microservices.reservation_app.handler.exception.InvalidUserException;

import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {


    @Autowired 
    private WebClient.Builder webClientBuilder;



    public UserValidationResponse validateUser(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }

        String url = "http://localhost:8090/api/user/validate?username={username}&password={password}";

        try {
            Mono<UserValidationResponse> response = webClientBuilder
                .build()
                .get()
                .uri(url, username, password)
                .retrieve()
                .bodyToMono(UserValidationResponse.class);

            return response.block();
        } catch (WebClientResponseException ex) {
            throw new InvalidUserException("User not found");
        }
    }
}
