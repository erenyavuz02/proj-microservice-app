package com.erenyavuz.microservices.reservation_app.dto;

import lombok.Builder;

@Builder
public record ReservationConfirmation(
        String PNR,
        Long flightNumber,
        String flightDate,
        String departurePort,
        String arrivalPort,
        String email
) {}