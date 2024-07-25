package com.erenyavuz.microservices.reservation_app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erenyavuz.microservices.reservation_app.entity.ReservationEntity;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, String> {

    ReservationEntity findByReservationId(String reservationId);

    
}
