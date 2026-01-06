package com.fitness.fitactivity.service;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserValidationService {
    private final WebClient userWebClient;
    public boolean validateUserId(String userId) {
        return userWebClient.get()
                .uri("/api/users/validate/{userid}", userId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();       

    }

}
