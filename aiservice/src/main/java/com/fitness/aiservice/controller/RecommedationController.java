package com.fitness.aiservice.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fitness.aiservice.model.Recommendation;
import com.fitness.aiservice.service.RecommedationService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendations")
public class RecommedationController {
private final RecommedationService recommedationService;

@GetMapping("/user/{userId}")
public ResponseEntity<List<Recommendation>> getRecommendationsByUserId(@PathVariable String userId) {
    // Implementation for fetching recommendations
    return ResponseEntity.ok(recommedationService.getRecommendationsByUserId(userId));
}
@GetMapping("/activity/{activityId}")
public ResponseEntity<Recommendation> getRecommendationsByActivityId(@PathVariable String activityId) {
    // Implementation for fetching recommendations
    return ResponseEntity.ok(recommedationService.getRecommendationsByActivityId(activityId));
}
}
