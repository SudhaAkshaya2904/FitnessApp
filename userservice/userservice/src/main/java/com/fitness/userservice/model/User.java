package com.fitness.userservice.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "users")
@Data

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String keycloakId;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
