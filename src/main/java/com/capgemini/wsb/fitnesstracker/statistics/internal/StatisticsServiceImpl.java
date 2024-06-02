package com.capgemini.wsb.fitnesstracker.statistics.internal;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsProvider;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsServiceImpl implements StatisticsProvider {

    private final StatisticsRepository statisticsRepository;

    @Override
    public List<Statistics> findAllStatistics() {
        return statisticsRepository.findAll();
    }

    @Override
    public List<Statistics> findStatisticsByUserId(final Long userId) {
        return statisticsRepository.findAllByUserId(userId);
    }

}
