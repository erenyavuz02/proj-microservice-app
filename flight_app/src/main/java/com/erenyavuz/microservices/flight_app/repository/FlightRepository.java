package com.erenyavuz.microservices.flight_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erenyavuz.microservices.flight_app.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {

    
}
