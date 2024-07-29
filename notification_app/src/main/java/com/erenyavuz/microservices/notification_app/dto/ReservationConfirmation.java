package com.erenyavuz.microservices.notification_app.dto;

/**
 * Represents a reservation confirmation.
 *
 * @param PNR the Passenger Name Record
 * @param flightNumber the flight number
 * @param flightDate the flight date
 * @param departurePort the departure port
 * @param arrivalPort the arrival port
 */
public record ReservationConfirmation(

    String PNR,
    Long flightNumber,
    String flightDate,
    String departurePort,
    String arrivalPort
) {

}
