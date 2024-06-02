package com.capgemini.wsb.fitnesstracker.training.internal;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.wsb.fitnesstracker.training.api.Training;

interface TrainingRepository extends JpaRepository<Training, Long> {
    /**
     * Query searching trainings by user ID.
     * 
     * @param userId the ID of the user to search for
     * @return a list of trainings for the specified user
     */
    default List<Training> findAllByUserId(Long userId) {
        return findAll().stream()
                .filter(training -> training.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }

    /**
     * Query searching trainings that are finished after a specific date.
     * 
     * @param date the date to compare with
     * @return a list of trainings that are finished after the specified date
     */
    default List<Training> findAllFinishedAfter(Date date) {
        return findAll().stream()
                .filter(training -> training.getEndTime().after(date))
                .collect(Collectors.toList());
    }

    /**
     * Query searching trainings by activity type.
     * 
     * @param activityType the activity type to search for
     * @return a list of trainings with the specified activity type
     */
    default List<Training> findAllByActivityType(ActivityType activityType) {
        return findAll().stream()
                .filter(training -> training.getActivityType().equals(activityType))
                .collect(Collectors.toList());
    }
}
