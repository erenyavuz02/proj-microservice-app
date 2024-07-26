package com.erenyavuz.microservices.flight_app.dto;

import com.erenyavuz.microservices.flight_app.entity.Flight;

import jakarta.validation.constraints.NotNull;

public record FlightConfirmation(    
    
@NotNull(message = "FlightNumber cannot be null")
String flightNumber,

@NotNull(message = "FlightDate cannot be null")
String flightDate,

@NotNull(message = "DeparturePort cannot be null")
String departurePort,

@NotNull(message = "ArrivalPort cannot be null")
String arrivalPort

) {


    public Flight toFlight() {
        return new Flight(
                flightNumber,
                flightDate,
                departurePort,
                arrivalPort
        );
    }

    
}
