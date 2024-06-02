package com.capgemini.wsb.fitnesstracker.statistics.internal;

import org.springframework.stereotype.Component;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsDto;
import com.capgemini.wsb.fitnesstracker.user.internal.UserMapper;

@Component
class StatisticsMapper {

    private final UserMapper userMapper;

    StatisticsMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    StatisticsDto toDto(Statistics statistics) {

        return new StatisticsDto(
                statistics.getId(),
                userMapper.toDto(statistics.getUser()),
                statistics.getTotalTrainings(),
                statistics.getTotalDistance(),
                statistics.getTotalCaloriesBurned());

    }

    // TODO
    // Statistics toEntity(InputTrainingDto inputTrainingDto, User user) {
    // return new Training(user,
    // inputTrainingDto.getStartTime(),
    // inputTrainingDto.getEndTime(),
    // inputTrainingDto.getActivityType(),
    // inputTrainingDto.getDistance(),
    // inputTrainingDto.getAverageSpeed());
    // }
}
