package com.erenyavuz.microservices.notification_app.dto;

public record   ReservationConfirmation(

    String PNR,
    String flightNumber,
    String flightDate,
    String departurePort,
    String arrivalPort
) {

}
