package com.erenyavuz.microservices.reservation_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "reservation")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationEntity {


    @Id
    String reservationId;
    String username;

}
