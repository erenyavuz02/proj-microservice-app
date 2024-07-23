package com.erenyavuz.microservices.user_app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRequest(

    @NotNull(message = "Username cannot be null")
    String username,
    @NotNull(message = "Password cannot be null")
    String password,
    @NotNull @Email(message = "Email cannot be null")
    String email
    
) {

}
