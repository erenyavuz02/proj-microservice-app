package com.erenyavuz.microservices.reservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.erenyavuz.microservices.reservation_app.dto.FlightDetails;
import com.erenyavuz.microservices.reservation_app.dto.FlightRequest;
import com.erenyavuz.microservices.reservation_app.dto.UserDetails;
import com.erenyavuz.microservices.reservation_app.handler.exception.InvalidUserException;

import reactor.core.publisher.Mono;

@Service
public class ExternalApiService {


    @Autowired 
    private WebClient.Builder webClientBuilder;



    public UserDetails validateUser(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }

        String url = "http://localhost:8090/api/user/validate?username={username}&password={password}";

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


    public FlightDetails getFlightDetails(FlightRequest flightRequest) {
        if (flightRequest.flightNumber() == null) {
            throw new IllegalArgumentException("Flight number cannot be null");
        }

        String url = "http://localhost:8090/api/flight/get";

        try {
            Mono<FlightDetails> response = webClientBuilder
                .build()
                .post()
                .uri(url)
                .bodyValue(flightRequest)
                .retrieve()
                .bodyToMono(FlightDetails.class);  

            return response.block();
        } catch (WebClientResponseException ex) {
            throw new IllegalArgumentException("Flight not found");
        }

    }
}
