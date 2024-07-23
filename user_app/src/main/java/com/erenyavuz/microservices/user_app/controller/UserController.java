package com.erenyavuz.microservices.user_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.erenyavuz.microservices.user_app.dto.UserRequest;
import com.erenyavuz.microservices.user_app.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    
}
