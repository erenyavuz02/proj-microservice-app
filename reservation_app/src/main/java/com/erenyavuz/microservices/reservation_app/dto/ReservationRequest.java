package com.erenyavuz.microservices.reservation_app.dto;

import jakarta.validation.constraints.NotNull;

public record ReservationRequest(
    @NotNull(message = "ReservationId cannot be null")
    String reservationId,
    @NotNull(message = "FlightNumber cannot be null")
    Long flightNumber,
    @NotNull(message = "Username cannot be null")
    String username,
    @NotNull(message = "Password cannot be null")
    String password
) {
} 
