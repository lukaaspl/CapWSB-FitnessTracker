package com.capgemini.wsb.fitnesstracker.statistics.internal;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.wsb.fitnesstracker.statistics.api.InputStatisticsDto;
import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
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

    @PostMapping
    public ResponseEntity<StatisticsDto> addStatistics(@RequestBody InputStatisticsDto inputStatisticsDto) {
        Statistics createdStatistics = statisticsService.createStatistics(inputStatisticsDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(statisticsMapper.toDto(createdStatistics));
    }

    @PutMapping("/{id}")
    public StatisticsDto updateStatistics(@PathVariable Long id, @RequestBody InputStatisticsDto inputStatisticsDto) {
        Statistics updatedStatistics = statisticsService.updateStatistics(id, inputStatisticsDto);

        return statisticsMapper.toDto(updatedStatistics);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStatistics(@PathVariable Long id) {
        statisticsService.deleteStatistics(id);
    }
}