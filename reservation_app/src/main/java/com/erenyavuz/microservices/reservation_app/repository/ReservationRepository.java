package com.erenyavuz.microservices.reservation_app.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erenyavuz.microservices.reservation_app.entity.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

    Reservation findByReservationId(String reservationId);

    
}
