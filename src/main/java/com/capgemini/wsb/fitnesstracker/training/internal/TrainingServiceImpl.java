package com.capgemini.wsb.fitnesstracker.training.internal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.wsb.fitnesstracker.training.api.InputTrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingNotFoundException;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingProvider;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingService;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserNotFoundException;
import com.capgemini.wsb.fitnesstracker.user.internal.UserServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TrainingServiceImpl implements TrainingService, TrainingProvider {

    private final TrainingRepository trainingRepository;

    private final TrainingMapper trainingMapper;

    private final UserServiceImpl userService;

    @Override
    public Training createTraining(final InputTrainingDto inputTrainingDto) {
        log.info("Creating Training {}", inputTrainingDto);

        Optional<User> user = userService.getUser(inputTrainingDto.getUserId());

        if (user.isEmpty()) {
            throw new UserNotFoundException(inputTrainingDto.getUserId());
        }

        return trainingRepository.save(trainingMapper.toEntity(inputTrainingDto, user.get()));
    }

    @Override
    public Training updateTraining(final Long trainingId, final InputTrainingDto inputTrainingDto) {
        log.info("Updating Training with ID {}", trainingId);

        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new TrainingNotFoundException(trainingId));

        training.setStartTime(inputTrainingDto.getStartTime());
        training.setEndTime(inputTrainingDto.getEndTime());
        training.setActivityType(inputTrainingDto.getActivityType());
        training.setDistance(inputTrainingDto.getDistance());
        training.setAverageSpeed(inputTrainingDto.getAverageSpeed());

        return trainingRepository.save(training);
    }

    @Override
    public Optional<User> getTraining(final Long trainingId) {
        throw new UnsupportedOperationException("Not finished yet");
    }

    @Override
    public List<Training> findAllTrainings() {
        return trainingRepository.findAll();
    }

    @Override
    public List<Training> findTrainingsByUserId(final Long userId) {

        if (!userService.getUser(userId).isPresent()) {
            throw new UserNotFoundException(userId);
        }

        return trainingRepository.findAllByUserId(userId);
    }

    @Override
    public List<Training> findTrainingsFinishedAfter(final LocalDate date) {
        LocalDateTime endOfDay = date.atTime(23, 59, 59);
        Date endOfDayAsDate = Date.from(endOfDay.atZone(ZoneId.of("UTC")).toInstant());

        return trainingRepository.findAllFinishedAfter(endOfDayAsDate);
    }

    @Override
    public List<Training> findTrainingsByActivityType(final ActivityType activityType) {
        return trainingRepository.findAllByActivityType(activityType);
    }

}
