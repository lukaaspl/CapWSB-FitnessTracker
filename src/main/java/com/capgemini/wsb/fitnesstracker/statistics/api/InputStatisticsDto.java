package com.capgemini.wsb.fitnesstracker.statistics.api;

import lombok.Data;

@Data
public class InputStatisticsDto {
    private Long userId;
    private int totalTrainings;
    private double totalDistance;
    private int totalCaloriesBurned;

    public InputStatisticsDto(
            Long userId,
            int totalTrainings,
            double totalDistance,
            int totalCaloriesBurned) {
        this.userId = userId;
        this.totalTrainings = totalTrainings;
        this.totalDistance = totalDistance;
        this.totalCaloriesBurned = totalCaloriesBurned;
    }
}
