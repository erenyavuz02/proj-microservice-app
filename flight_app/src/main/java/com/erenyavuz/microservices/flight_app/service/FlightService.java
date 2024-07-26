package com.erenyavuz.microservices.flight_app.service;

import org.springframework.stereotype.Service;

import com.erenyavuz.microservices.flight_app.dto.FlightConfirmation;
import com.erenyavuz.microservices.flight_app.dto.FlightRequest;
import com.erenyavuz.microservices.flight_app.dto.UserValidationResponse;
import com.erenyavuz.microservices.flight_app.handler.exception.InvalidUserException;
import com.erenyavuz.microservices.flight_app.repository.FlightRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FlightService {
    
    private final FlightRepository flightRepository;

    ExternalApiService externalApiService;

    public FlightConfirmation getFlightByFlightNumber(FlightRequest flightRequest) {

        String username = flightRequest.username();
        String password = flightRequest.password();

        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }


        UserValidationResponse response = externalApiService.validateUser(username, password);
        if (!response.isValid()) {
            throw new InvalidUserException("User not found");
        }
        



        return flightRepository.findById(flightRequest.flightId())
            .map(flight -> new FlightConfirmation(flight.getFlightNumber(), flight.getFlightDate(), flight.getDeparturePort(), flight.getArrivalPort()))
            .orElse(null);
    }

    public void addFlight(FlightConfirmation flightConfirmation) {

        
        flightRepository.save(flightConfirmation.toFlight());
    }


}
