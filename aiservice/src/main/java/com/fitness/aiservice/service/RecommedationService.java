package com.fitness.aiservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fitness.aiservice.repository.RecommedationRepository;
import com.fitness.aiservice.model.Recommendation;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecommedationService {

private final RecommedationRepository recommedationRepository;

public List<Recommendation> getRecommendationsByUserId(String userId) {
    return recommedationRepository.findByUserId(userId);
}

public Recommendation getRecommendationsByActivityId(String activityId) {
    return recommedationRepository.findByActivityId(activityId).orElseThrow(() -> new RuntimeException("No recommendation found for activityId: " + activityId));
}

}