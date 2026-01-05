package com.fitness.userservice.dto;

import java.time.LocalDateTime;
import com.fitness.userservice.model.UserRole;
import lombok.Data;

@Data
public class UserResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String keycloakId;
    private UserRole role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
