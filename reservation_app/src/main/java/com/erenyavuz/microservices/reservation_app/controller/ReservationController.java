package com.erenyavuz.microservices.reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erenyavuz.microservices.reservation_app.dto.ReservationConfirmation;
import com.erenyavuz.microservices.reservation_app.dto.ReservationRequest;
import com.erenyavuz.microservices.reservation_app.kafka.ReservationProducer;
import com.erenyavuz.microservices.reservation_app.service.ReservationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationProducer reservationProducer;


    @PostMapping("/create")
    public ResponseEntity<String> createReservation(@RequestBody ReservationRequest reservationRequest) {
       
            
        ReservationConfirmation reservationConfirmation  = reservationService.createReservation(reservationRequest);


        reservationProducer.sendReservation(reservationConfirmation);

        return ResponseEntity.ok("Reservation created successfully");
        
    }



}
