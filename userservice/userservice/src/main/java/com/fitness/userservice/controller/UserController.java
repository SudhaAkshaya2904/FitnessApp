package com.fitness.userservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController  {
    public UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterRequest request) {
        UserResponse entity = userService.registerUser(request);
        return ResponseEntity.ok(entity);
    }
    @GetMapping("/user/{userid}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String userid) {
        return ResponseEntity.ok(userService.getUserById(userid));
    }

    // endpoint to validate if user exists
    @GetMapping("/validate/{userid}")
    public ResponseEntity<Boolean> validateUser(@PathVariable String userid) {
        boolean isValid = userService.validateUser(userid);
        return ResponseEntity.ok(isValid);
    }
    
    

    

}
