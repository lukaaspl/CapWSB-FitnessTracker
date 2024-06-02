package com.capgemini.wsb.fitnesstracker.statistics.internal;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/statistics")
@RequiredArgsConstructor
class StatisticsController {

    private final StatisticsServiceImpl statisticsService;

    private final StatisticsMapper statisticsMapper;

    @GetMapping
    public List<StatisticsDto> getAllStatistics() {
        return statisticsService.findAllStatistics().stream().map(statisticsMapper::toDto).toList();
    }

    @GetMapping("/{userId}")
    public List<StatisticsDto> getStatisticsByUserId(@PathVariable Long userId) {
        return statisticsService.findStatisticsByUserId(userId).stream().map(statisticsMapper::toDto).toList();
    }
}