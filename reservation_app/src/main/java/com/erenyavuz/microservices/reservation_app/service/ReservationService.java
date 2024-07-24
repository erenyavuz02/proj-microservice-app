package com.erenyavuz.microservices.reservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.erenyavuz.microservices.reservation_app.Reservation.ReservationRepository;
import com.erenyavuz.microservices.reservation_app.dto.ReservationRequest;
import com.erenyavuz.microservices.reservation_app.dto.UserValidationResponse;
import com.erenyavuz.microservices.reservation_app.entity.ReservationEntity;
import com.erenyavuz.microservices.reservation_app.handler.exception.InvalidUserException;



@Service
public class ReservationService {
    
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ExternalApiService externalApiService;

    public void createReservation(ReservationRequest reservationRequest) {
        String username = reservationRequest.username();
        String password = reservationRequest.password();

        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password cannot be null");
        }

        UserValidationResponse response = externalApiService.validateUser(username, password);
        if (!response.isValid()) {
            throw new InvalidUserException("User not found");
        }

        ReservationEntity reservationEntity = ReservationEntity.builder()
                .reservationId(reservationRequest.reservationId())
                .username(username)
                .build();
        reservationRepository.save(reservationEntity);
    }

}
