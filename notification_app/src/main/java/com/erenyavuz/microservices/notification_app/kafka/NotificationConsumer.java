package com.erenyavuz.microservices.notification_app.kafka;

import org.springframework.stereotype.Service;

import com.erenyavuz.microservices.notification_app.dto.ReservationConfirmation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    

    public void consumeReservationSuccessNotification(ReservationConfirmation message) {
        log.info("Received reservation success notification: {}", message);
    }
}
