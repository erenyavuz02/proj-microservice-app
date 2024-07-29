package com.erenyavuz.microservices.reservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erenyavuz.microservices.reservation_app.dto.FlightDetails;
import com.erenyavuz.microservices.reservation_app.dto.FlightRequest;
import com.erenyavuz.microservices.reservation_app.dto.ReservationConfirmation;
import com.erenyavuz.microservices.reservation_app.dto.ReservationRequest;
import com.erenyavuz.microservices.reservation_app.dto.UserValidationResponse;
import com.erenyavuz.microservices.reservation_app.entity.Reservation;
import com.erenyavuz.microservices.reservation_app.handler.exception.FlightNotFoundException;
import com.erenyavuz.microservices.reservation_app.handler.exception.InvalidUserException;
import com.erenyavuz.microservices.reservation_app.repository.ReservationRepository;



@Service
public class ReservationService {
    
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ExternalApiService externalApiService;

    public ReservationConfirmation createReservation(ReservationRequest reservationRequest) {
        String username = reservationRequest.username();
        String password = reservationRequest.password();

        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }

        UserValidationResponse response = externalApiService.validateUser(username, password);
        if (!response.isValid()) {
            throw new InvalidUserException("User not found");
        }

        FlightRequest flightRequest = new FlightRequest(
            reservationRequest.flightNumber()
            , username
            , password);

        FlightDetails flightDetails = externalApiService.getFlightDetails(flightRequest);
        if (flightDetails == null) {
            throw new FlightNotFoundException("Flight not found");
        }
        
        Reservation reservation = Reservation.builder()
                .reservationId(reservationRequest.reservationId())
                .username(username)
                .build();
        reservationRepository.save(reservation);

        ReservationConfirmation reservationConfirmation = ReservationConfirmation.builder()
                .PNR(reservationRequest.reservationId())
                .flightNumber(flightRequest.flightNumber())
                .flightDate(flightDetails.flightDate())
                .departurePort(flightDetails.departurePort())
                .arrivalPort(flightDetails.arrivalPort())
                .build();

        return reservationConfirmation;


    }

}
