package com.fitness.aiservice.service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.fitness.aiservice.model.Activity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {
    private static final String QUEUE_NAME = "fitactivity-queue";
    private final ActivityAIService activityAIService;
    // Message listener methods will be implemented here
 @RabbitListener(queues = QUEUE_NAME)
    public void processActiviityMessage(Activity activity) {
        String activityPlan=activityAIService.generateActivityPlan(activity);
        // Implementation for processing activity messages
        log.info("Processing activity message: {}", activityPlan);  
    }


}
