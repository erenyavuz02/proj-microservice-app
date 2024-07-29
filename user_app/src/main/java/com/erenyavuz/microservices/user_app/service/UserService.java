package com.erenyavuz.microservices.user_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.erenyavuz.microservices.user_app.dto.UserDetails;
import com.erenyavuz.microservices.user_app.dto.UserRequest;
import com.erenyavuz.microservices.user_app.entity.UserEntity;
import com.erenyavuz.microservices.user_app.handler.exception.CustomerNotFoundException;
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
            .name(userRequest.name())
            .surname(userRequest.surname())
            .build();
        
        userRepository.save(userEntity);

        return "User created successfully";
    }

    /**
     * This method returns true if the user information is exists in database
     *
     * @param username The username of the user (String)
     * @param password The password of the user (String)
     * @return True if the user information is valid, false otherwise (boolean)
     */
    public boolean isValidUser(@NonNull String username, @NonNull String password) {

        Optional<UserEntity> userEntity = userRepository.findByUsername(username);
        return userEntity.map(entity -> entity.getPassword().equals(password)).orElseThrow(() -> new CustomerNotFoundException("User not found"));
    }

    public UserDetails getUserDetails(String username, String password) {
        Optional<UserEntity> userEntity = userRepository.findByUsername(username);

        UserDetails userDetails = UserDetails.builder()
            .name(userEntity.get().getName())
            .surname(userEntity.get().getSurname())
            .email(userEntity.get().getEmail())
            .build();


        return userDetails;

    }
}
