package com.erenyavuz.microservices.notification_app.entity;

import java.time.LocalDateTime;

import com.erenyavuz.microservices.notification_app.dto.ReservationConfirmation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Notification {

    private String id;
    private String message;
    private NotificationType notificationType;
    private LocalDateTime notificationDate;
    private ReservationConfirmation reservationConfirmation;
    
}
