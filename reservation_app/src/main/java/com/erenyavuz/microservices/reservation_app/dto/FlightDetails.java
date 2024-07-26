package com.erenyavuz.microservices.reservation_app.dto;

public record FlightDetails(

    String flightNumber,

    String flightDate,

    String departurePort,

    String arrivalPort

) {
    
}
