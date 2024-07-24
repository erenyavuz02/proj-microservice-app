package com.erenyavuz.microservices.flight_app.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.erenyavuz.microservices.flight_app.dto.FlightConfirmation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class FlightProducer {
    
    private final KafkaTemplate<String, FlightConfirmation> kafkaTemplate;

    public void sendFlightConfirmation(FlightConfirmation flightConfirmation) {
        log.info("Sending flight confirmation: {}", flightConfirmation);
        Message<FlightConfirmation> message = MessageBuilder
            .withPayload(flightConfirmation)
            .setHeader(KafkaHeaders.TOPIC, "flight-topic")
            .build();

        kafkaTemplate.send(message);
         
    }
}
