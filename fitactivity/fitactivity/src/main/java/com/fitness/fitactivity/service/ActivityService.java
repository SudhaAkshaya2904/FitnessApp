package com.fitness.fitactivity.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fitness.fitactivity.model.Activity;
import com.fitness.fitactivity.repository.ActivityRepository;
import com.fitness.fitactivity.dto.ActivityRequest;
import com.fitness.fitactivity.dto.ActivityResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ActivityService {

    public final ActivityRepository activityRepository;
    private final UserValidationService userValidationService;
    @Value("${rabbitmq.exchange.name}")
    private String exchangeName = "fitactivity-exchange";
    @Value("${rabbitmq.routing.key}")
    private String routingKey = "fitactivity-routingkey";
    private final RabbitTemplate rabbitTemplate;

    public ActivityResponse trackActivity(ActivityRequest request) {
        if (!userValidationService.validateUserId(request.getUserId())) {
                log.info("Tracking activity for user ID: {}", request.getUserId());

            throw new IllegalArgumentException("Invalid user ID");
        }
       

        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                //.startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);
        //Publish to RabbitMQ can be added here in the future
       try {
            rabbitTemplate.convertAndSend(exchangeName, routingKey, savedActivity);
        } catch (Exception e) {
           log.error("Failed to publish activity to RabbitMQ: {}", e.getMessage());
        }

         log.info("Activity tracked with ID: {}", savedActivity.getId());

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
