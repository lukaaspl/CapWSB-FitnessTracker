package com.capgemini.wsb.fitnesstracker.training.internal;

import org.springframework.stereotype.Component;

import com.capgemini.wsb.fitnesstracker.training.api.InputTrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.internal.UserMapper;

@Component
class TrainingMapper {

    private final UserMapper userMapper;

    TrainingMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    TrainingDto toDto(Training training) {
        return new TrainingDto(
                training.getId(),
                userMapper.toDto(training.getUser()),
                training.getStartTime(), training.getEndTime(),
                training.getActivityType(),
                training.getDistance(),
                training.getAverageSpeed());
    }

    Training toEntity(InputTrainingDto inputTrainingDto, User user) {
        return new Training(user,
                inputTrainingDto.getStartTime(),
                inputTrainingDto.getEndTime(),
                inputTrainingDto.getActivityType(),
                inputTrainingDto.getDistance(),
                inputTrainingDto.getAverageSpeed());
    }
}
