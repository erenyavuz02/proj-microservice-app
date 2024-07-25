package com.erenyavuz.microservices.reservation_app.dto;

public record ReservationConfirmation(
        String PNR,
        String flightNumber,
        String flightDate,
        String departurePort,
        String arrivalPort
) {}