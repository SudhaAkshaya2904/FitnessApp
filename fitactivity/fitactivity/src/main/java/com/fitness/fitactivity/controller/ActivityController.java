package com.fitness.fitactivity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.fitactivity.dto.ActivityRequest;
import com.fitness.fitactivity.dto.ActivityResponse;
import com.fitness.fitactivity.service.ActivityService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/api/activities")
@RestController
@Slf4j
@AllArgsConstructor

public class ActivityController {
    ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request, @RequestHeader("X-User-ID") String userId){
        if (userId != null) {
            request.setUserId(userId);
        }
        return ResponseEntity.ok(activityService.trackActivity(request));
    }


}
