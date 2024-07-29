package com.erenyavuz.microservices.reservation_app.dto;

import lombok.Builder;


@Builder
public record  UserDetails(

    String name,
    String surname,
    String email

) {
    
}
