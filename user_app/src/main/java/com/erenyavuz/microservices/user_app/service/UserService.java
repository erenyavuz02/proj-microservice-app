package com.erenyavuz.microservices.user_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erenyavuz.microservices.user_app.dto.UserRequest;
import com.erenyavuz.microservices.user_app.entity.UserEntity;
import com.erenyavuz.microservices.user_app.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    
    public String createUser(UserRequest userRequest) {

        UserEntity userEntity = UserEntity.builder()
            .username(userRequest.username())
            .password(userRequest.password())
            .email(userRequest.email())
            .build();
        
        userRepository.save(userEntity);

        return "User created successfully";
    }
}
