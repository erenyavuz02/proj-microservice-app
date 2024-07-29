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
public class Reservation {


    @Id
    String reservationId;
    String username;

}
