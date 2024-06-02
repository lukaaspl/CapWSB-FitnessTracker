package com.capgemini.wsb.fitnesstracker.statistics.api;

import com.capgemini.wsb.fitnesstracker.exception.api.NotFoundException;

/**
 * Exception indicating that the {@link Statistics} was not found.
 */
@SuppressWarnings("squid:S110")
public class StatisticsNotFoundException extends NotFoundException {

    private StatisticsNotFoundException(String message) {
        super(message);
    }

    public StatisticsNotFoundException(Long id) {
        this("Statistics with ID=%s was not found".formatted(id));
    }

}
