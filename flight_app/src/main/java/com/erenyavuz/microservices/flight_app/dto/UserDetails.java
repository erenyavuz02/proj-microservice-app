package com.erenyavuz.microservices.flight_app.dto;
import lombok.Builder;


@Builder
public record  UserDetails(

    String name,
    String surname,
    String email

) {
    
}