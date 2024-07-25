package com.erenyavuz.microservices.flight_app.handler.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvalidUserException extends RuntimeException{

    private final String msg;
}
