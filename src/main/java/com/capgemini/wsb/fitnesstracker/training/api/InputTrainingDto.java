package com.capgemini.wsb.fitnesstracker.training.api;

import java.util.Date;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;

import lombok.Data;

@Data
public class InputTrainingDto {
    private Long userId;
    private Date startTime;
    private Date endTime;
    private ActivityType activityType;
    private double distance;
    private double averageSpeed;

    public InputTrainingDto(
            Long userId,
            Date startTime,
            Date endTime,
            ActivityType activityType,
            double distance,
            double averageSpeed) {
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.activityType = activityType;
        this.distance = distance;
        this.averageSpeed = averageSpeed;
    }
}
