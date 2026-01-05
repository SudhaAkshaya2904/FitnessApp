package com.fitness.userservice.dto;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequest {

    private String firstName;
    private String lastName;
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    private String keycloakId;
 

}
