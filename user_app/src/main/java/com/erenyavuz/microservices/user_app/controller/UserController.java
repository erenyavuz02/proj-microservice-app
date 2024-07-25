package com.erenyavuz.microservices.user_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.erenyavuz.microservices.user_app.dto.UserRequest;
import com.erenyavuz.microservices.user_app.handler.GlobalExceptionHandler;
import com.erenyavuz.microservices.user_app.handler.exception.CustomerNotFoundException;
import com.erenyavuz.microservices.user_app.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    
    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public ResponseEntity<String> postMethodName(
        @RequestBody  @Valid UserRequest userRequest) {

        userService.createUser(userRequest);

        return ResponseEntity.ok("User created successfully");
    }


/**
     * This function validates if the sent user information exists
     * 
     * @param username the username of the user
     * @param password the password of the user
     * @return ResponseEntity with the validation result
     */
    @GetMapping("/validate")
    public ResponseEntity<Boolean> getMethodName(
        @RequestParam String username,
        @RequestParam String password
    ) {

        if (username == null || password == null) {
            throw new CustomerNotFoundException("Username and password cannot be null");
        }

        Boolean isValid = userService.isValidUser(username, password);

        if (!isValid) {
            throw new CustomerNotFoundException("User not found");
        }


        return ResponseEntity.ok(isValid);
        // Check if the user is valid
        
    }
    
}
