package com.erenyavuz.microservices.flight_app.dto;

import jakarta.validation.constraints.NotNull;

public record FlightRequest(

    @NotNull(message = "FlightNumber cannot be null")
    Long flightNumber,
    @NotNull(message = "Username cannot be null")
    String username,
    @NotNull(message = "Password cannot be null")
    String password
) {

    public void validate() {
        if (flightNumber == null || username == null || password == null) {
            throw new IllegalArgumentException("FlightId, username and password cannot be null");
        }
    }
    
}
