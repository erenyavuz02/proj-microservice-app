package com.erenyavuz.microservices.notification_app.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.erenyavuz.microservices.notification_app.dto.ReservationConfirmation;
import com.erenyavuz.microservices.notification_app.service.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    
    
    private final EmailService emailService;

    @KafkaListener(topics = "reservation-topic")
    public void consumeReservationSuccessNotification(ReservationConfirmation message) {
        log.info("Received reservation success notification: {}", message);

        //TODO: send email
        System.out.println(message);

        emailService.sendEmail(message);

        System.out.println("Mail sent successfully");

    }
}
