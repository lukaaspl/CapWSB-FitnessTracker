package com.capgemini.wsb.fitnesstracker.statistics.api;

import com.capgemini.wsb.fitnesstracker.user.api.UserDto;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class StatisticsDto {
    private Long id;
    private UserDto user;
    private int totalTrainings;
    private double totalDistance;
    private int totalCaloriesBurned;

    public StatisticsDto(
            @Nullable Long id,
            UserDto user,
            int totalTrainings,
            double totalDistance,
            int totalCaloriesBurned) {
        this.id = id;
        this.user = user;
        this.totalTrainings = totalTrainings;
        this.totalDistance = totalDistance;
        this.totalCaloriesBurned = totalCaloriesBurned;
    }
}
