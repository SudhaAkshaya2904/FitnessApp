package com.fitness.fitactivity.service;

import org.springframework.stereotype.Service;

import com.fitness.fitactivity.model.Activity;
import com.fitness.fitactivity.repository.ActivityRepository;
import com.fitness.fitactivity.dto.ActivityRequest;
import com.fitness.fitactivity.dto.ActivityResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ActivityService {

    public ActivityRepository activityRepository;

    public ActivityResponse trackActivity(ActivityRequest request) {

     
        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                //.startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);

        return mapToResponse(savedActivity);
    }

    private ActivityResponse mapToResponse(Activity activity){
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUserId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        return response;
    }

}
