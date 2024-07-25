package com.erenyavuz.microservices.flight_app.dto;

import jakarta.validation.constraints.NotNull;

public record FlightRequest(

    @NotNull(message = "FlightId cannot be null")
    String flightId,
    @NotNull(message = "Username cannot be null")
    String username,
    @NotNull(message = "Password cannot be null")
    String password
) {

    public void validate() {
        if (flightId == null || username == null || password == null) {
            throw new IllegalArgumentException("FlightId, username and password cannot be null");
        }
    }
    
}
