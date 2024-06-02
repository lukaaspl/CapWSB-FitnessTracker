package com.capgemini.wsb.fitnesstracker.statistics.internal;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;

interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    /**
     * Query searching statistics by user ID.
     * 
     * @param userId the ID of the user to search for
     * @return a list of statistics for the specified user
     */
    default List<Statistics> findAllByUserId(Long userId) {
        return findAll().stream()
                .filter(statistics -> statistics.getUser().getId().equals(userId))
                .collect(Collectors.toList());
    }
}
