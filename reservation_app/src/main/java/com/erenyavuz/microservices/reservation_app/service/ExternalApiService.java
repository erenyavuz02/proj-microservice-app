package com.erenyavuz.microservices.reservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.erenyavuz.microservices.reservation_app.dto.UserValidationResponse;

import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {


    @Autowired 
    private WebClient.Builder webClientBuilder;



    public UserValidationResponse validateUser(String username, String password) {

        String url = "http://localhost:8080/api/user/validate?username={username}&password={password}";

        Mono<UserValidationResponse> response = webClientBuilder
            .build()
            .get()
            .uri(url, username, password)
            .retrieve()
            .bodyToMono(UserValidationResponse.class);

        return response.block();
    }
}
