package com.capgemini.wsb.fitnesstracker.training.internal;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.wsb.fitnesstracker.training.api.InputTrainingDto;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/trainings")
@RequiredArgsConstructor
class TrainingController {

    private final TrainingServiceImpl trainingService;

    private final TrainingMapper trainingMapper;

    @GetMapping
    public List<TrainingDto> getAllTrainings() {
        return trainingService.findAllTrainings().stream().map(trainingMapper::toDto).toList();
    }

    @GetMapping("/{userId}")
    public List<TrainingDto> getTrainingsByUserId(@PathVariable Long userId) {
        return trainingService.findTrainingsByUserId(userId).stream().map(trainingMapper::toDto).toList();
    }

    @GetMapping("/finished/{date}")
    public List<TrainingDto> getFinishedTrainingsAfter(@PathVariable LocalDate date) {
        return trainingService.findTrainingsFinishedAfter(date).stream().map(trainingMapper::toDto).toList();
    }

    @GetMapping("/activityType")
    public List<TrainingDto> getTrainingsByActivityType(@RequestParam ActivityType activityType) {
        return trainingService.findTrainingsByActivityType(activityType).stream().map(trainingMapper::toDto).toList();
    }

    @PostMapping
    public ResponseEntity<TrainingDto> addTraining(@RequestBody InputTrainingDto inputTrainingDto)
            throws InterruptedException {

        Training createdTraining = trainingService.createTraining(inputTrainingDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(trainingMapper.toDto(createdTraining));
    }

    @PutMapping("/{id}")
    public TrainingDto updateTraining(@PathVariable Long id, @RequestBody InputTrainingDto inputTrainingDto) {
        Training updatedTraining = trainingService.updateTraining(id, inputTrainingDto);

        return trainingMapper.toDto(updatedTraining);
    }

}