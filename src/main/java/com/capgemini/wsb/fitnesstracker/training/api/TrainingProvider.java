package com.capgemini.wsb.fitnesstracker.training.api;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.capgemini.wsb.fitnesstracker.training.internal.ActivityType;
import com.capgemini.wsb.fitnesstracker.user.api.User;

public interface TrainingProvider {

    /**
     * Retrieves a training based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be
     * returned.
     *
     * @param trainingId id of the training to be searched
     * @return An {@link Optional} containing the located Training, or
     *         {@link Optional#empty()} if not found
     */
    Optional<User> getTraining(Long trainingId);

    /**
     * Retrieves all trainings.
     *
     * @return A list of all trainings
     */
    List<Training> findAllTrainings();

    /**
     * Retrieves all trainings for a given user.
     *
     * @param userId id of the user
     * @return A list of all trainings for the user
     */
    List<Training> findTrainingsByUserId(Long userId);

    /**
     * Retrieves all trainings that are finished after a given date.
     *
     * @param date date after which the trainings are finished
     * @return A list of all trainings that are finished after the given date
     */
    List<Training> findTrainingsFinishedAfter(LocalDate date);

    /**
     * Retrieves all trainings that are of a given activity type.
     * 
     * @param activityType the activity type to search for
     * @return A list of all trainings with the specified activity type
     */
    List<Training> findTrainingsByActivityType(ActivityType activityType);

    /**
     * Retrieves all trainings that are between two given dates.
     *
     * @param startDate the start date
     * @param endDate   the end date
     * @return A list of all trainings that are between the two given dates
     */
    List<Training> findTrainingsBetweenDates(Date startDate, Date endDate);
}
