package com.capgemini.wsb.fitnesstracker.training.api;

public interface TrainingService {

    Training createTraining(InputTrainingDto inputTrainingDto);

    Training updateTraining(Long trainingId, InputTrainingDto inputTrainingDto);

}
