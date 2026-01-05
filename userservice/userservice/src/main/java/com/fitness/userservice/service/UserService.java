package com.fitness.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fitness.userservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import com.fitness.userservice.model.User;
import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;

@Service
@AllArgsConstructor
public class UserService {
    @Autowired
    public UserRepository repository;

    public UserResponse registerUser(RegisterRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setKeycloakId(request.getKeycloakId());

        User savedUser = repository.save(user);

        UserResponse response = new UserResponse();
        response.setId(savedUser.getId());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setEmail(savedUser.getEmail());
        response.setPassword(savedUser.getPassword());
        response.setKeycloakId(savedUser.getKeycloakId());
        response.setRole(savedUser.getRole());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());

        return response;
    }

    public UserResponse getUserById(String userId) {
        User user = repository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setPassword(user.getPassword());
        response.setKeycloakId(user.getKeycloakId());
        response.setRole(user.getRole());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());

        return response;
    }



}
