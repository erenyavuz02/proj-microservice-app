package com.erenyavuz.microservices.reservation_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.erenyavuz.microservices.reservation_app.Reservation.ReservationRepository;
import com.erenyavuz.microservices.reservation_app.dto.ReservationRequest;
import com.erenyavuz.microservices.reservation_app.dto.UserValidationResponse;
import com.erenyavuz.microservices.reservation_app.entity.ReservationEntity;

import jakarta.ws.rs.core.Response;

@Service
public class ReservationService {
    
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ExternalApiService externalApiService;

    // Fetching user validation from external API
    public void createReservation(ReservationRequest reservationRequest) {

        // Fetching user validation from external API
        String username = reservationRequest.username();
        String password = reservationRequest.password();
        
    // Implementing code to fetch user validation from external API
        UserValidationResponse response = externalApiService.validateUser(username, password);
        if (response.isValid()) {
            ReservationEntity reservationEntity = ReservationEntity.builder()
                .reservationId(reservationRequest.reservationId())
                .username(username)
                .build();
            reservationRepository.save(reservationEntity);
        } else {
            // Handle invalid user response
            throw new InvalidUserException("User not fo");}

    }
}
