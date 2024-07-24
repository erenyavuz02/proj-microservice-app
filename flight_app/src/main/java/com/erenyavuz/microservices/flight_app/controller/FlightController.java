package com.erenyavuz.microservices.flight_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erenyavuz.microservices.flight_app.dto.FlightConfirmation;
import com.erenyavuz.microservices.flight_app.kafka.FlightProducer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/flight")
public class FlightController {
    

    private final FlightProducer producer;

    @PostMapping("/add")
    public ResponseEntity<String> postMethodName(@RequestBody FlightConfirmation flightConfirmation) {
        //TODO: process POST request
        

        producer.sendFlightConfirmation(flightConfirmation);

        return ResponseEntity.ok(" Flight added successfully");
    }
    


}
