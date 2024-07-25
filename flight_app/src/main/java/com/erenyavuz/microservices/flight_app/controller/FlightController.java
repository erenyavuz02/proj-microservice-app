package com.erenyavuz.microservices.flight_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erenyavuz.microservices.flight_app.dto.FlightConfirmation;
import com.erenyavuz.microservices.flight_app.dto.FlightRequest;
import com.erenyavuz.microservices.flight_app.kafka.FlightProducer;
import com.erenyavuz.microservices.flight_app.service.ExternalApiService;
import com.erenyavuz.microservices.flight_app.service.FlightService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/flight")
public class FlightController {
    

    private final FlightProducer producer;


    private FlightService flightService;


    @PostMapping("/add")
    public ResponseEntity<String> postMethodName(@RequestBody FlightConfirmation flightConfirmation) {
        //TODO: process POST request
        

        producer.sendFlightConfirmation(flightConfirmation);

        return ResponseEntity.ok(" Flight added successfully");
    }

    @GetMapping("/get")
    public ResponseEntity<FlightConfirmation> getMethodName(@RequestBody FlightRequest flightRequest) {



        FlightConfirmation flight = flightService.getFlightByFlightNumber(flightRequest);
        
        if (flight == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(flight);
    }
    
    


}
