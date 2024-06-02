package com.capgemini.wsb.fitnesstracker.statistics.internal;

import org.springframework.stereotype.Component;

import com.capgemini.wsb.fitnesstracker.statistics.api.InputStatisticsDto;
import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsDto;
import com.capgemini.wsb.fitnesstracker.user.api.User;
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

    Statistics toEntity(InputStatisticsDto inputStatisticsDto, User user) {
        return new Statistics(user,
                inputStatisticsDto.getTotalTrainings(),
                inputStatisticsDto.getTotalDistance(),
                inputStatisticsDto.getTotalCaloriesBurned());
    }
}
