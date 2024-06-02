package com.capgemini.wsb.fitnesstracker.statistics.api;

import java.util.List;

public interface StatisticsProvider {

    /**
     * Retrieves all statistics.
     *
     * @return A list of all statistics
     */
    List<Statistics> findAllStatistics();

    /**
     * Retrieves a statistics based on the owner ID.
     * 
     * @param userId id of the user
     * @return A list of all statistics for the user
     */
    List<Statistics> findStatisticsByUserId(Long userId);

}
