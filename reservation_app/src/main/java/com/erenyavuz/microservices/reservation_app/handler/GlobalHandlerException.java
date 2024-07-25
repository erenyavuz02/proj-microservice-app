package com.erenyavuz.microservices.reservation_app.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.erenyavuz.microservices.reservation_app.handler.exception.InvalidUserException;

@RestControllerAdvice
public class GlobalHandlerException {


    @ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<String> handleInvalidUserException(InvalidUserException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMsg());
    }
    
}
