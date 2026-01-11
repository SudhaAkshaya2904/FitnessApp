package com.fitness.aiservice.service;

import org.springframework.stereotype.Service;
import com.fitness.aiservice.model.Activity;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ActivityAIService {
    private final GeminiService geminiService;
    public ActivityAIService(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    public String generateActivityPlan(Activity activity) {
        String prompt = creatPromptFromActivity(activity);
        String response = geminiService.generateContent(prompt);
        log.info("Generated Activity Plan: {}", response);
        return response;
    }

    private String creatPromptFromActivity(Activity activity) {
        String prompt = String.format("""
    Analyze this fitnessactivity and create a detailed recommendation in below exact json format:
       		 {
       			 "Analysis" : {"overall": "Overall analysis here", "pace": "Pace analysis here"," heartRate": "Heart rate analysis here", "calories burned": "Calories burned analysis here"},
        		 "improvements" : ["area", "Area name"],["Recommendation", "Detailed recommendation here"],},
        		 "Suggestions" :[{"Workout Name": "Name of workout", "Description": "Detailed description of the workout", "Duration": "Duration in minutes", "Intensity": "Low/Medium/High"}],
        		 "Safety" : {"Precautions": "List of safety precautions to consider during the activity"},
        		"Motivation" : {"Tips": "List of motivational tips to stay consistent with the activity"},
        	} 
    activity data: Type: %s, 
    Duration: %d minutes, 
    CaloriesBurned: %d,
    Metrics:%s
    """,
    activity.getType(),
    activity.getDuration(),
    activity.getCaloriesBurned(),
    activity.getAdditionalMetrics()
);
        return prompt;
    }
}
