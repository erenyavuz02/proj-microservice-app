package com.erenyavuz.microservices.reservation_app.handler.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InvalidUserException extends RuntimeException{

    private final String msg;
}
