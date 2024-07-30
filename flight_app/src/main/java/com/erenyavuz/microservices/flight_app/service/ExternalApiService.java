package com.erenyavuz.microservices.flight_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.erenyavuz.microservices.flight_app.dto.UserDetails;
import com.erenyavuz.microservices.flight_app.handler.exception.InvalidUserException;

import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {


    @Autowired 
    private WebClient.Builder webClientBuilder;



    public UserDetails validateUser(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }

        String url = "http://user:8090/api/user/validate?username={username}&password={password}";

        try {
            Mono<UserDetails> response = webClientBuilder
                .build()
                .get()
                .uri(url, username, password)
                .retrieve()
                .bodyToMono(UserDetails.class);

            return response.block();
        } catch (WebClientResponseException ex) {
            throw new InvalidUserException("User not found");
        }
    }
}
