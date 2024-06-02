package com.capgemini.wsb.fitnesstracker.statistics.api;

public interface StatisticsService {

    Statistics createStatistics(InputStatisticsDto inputStatisticsDto);

    Statistics updateStatistics(Long statisticsId, InputStatisticsDto inputStatisticsDto);

    void deleteStatistics(Long statisticsId);

}
