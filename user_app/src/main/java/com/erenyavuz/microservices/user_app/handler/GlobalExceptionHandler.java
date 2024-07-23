package com.erenyavuz.microservices.user_app.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.erenyavuz.microservices.user_app.handler.exception.CustomerNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    

    @ExceptionHandler(CustomerNotFoundException.class)
    public static ResponseEntity<String> handleException(CustomerNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMsg());
    }

    /**
     * Handles MethodArgumentNotValidException exceptions by returning a ResponseEntity
     * with a BAD_REQUEST status code and an ErrorResponse body containing the validation errors.
     *
     * @param exception the MethodArgumentNotValidException to handle
     * @return a ResponseEntity containing an ErrorResponse with validation errors
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        StringBuilder errorMessage = new StringBuilder();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMessage.append(error.getField()).append(": ").append(error.getDefaultMessage()).append(", ");
        });
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString());
    }
}
