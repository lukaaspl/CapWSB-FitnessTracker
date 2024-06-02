package com.capgemini.wsb.fitnesstracker.statistics.internal;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capgemini.wsb.fitnesstracker.statistics.api.InputStatisticsDto;
import com.capgemini.wsb.fitnesstracker.statistics.api.Statistics;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsNotFoundException;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsProvider;
import com.capgemini.wsb.fitnesstracker.statistics.api.StatisticsService;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserNotFoundException;
import com.capgemini.wsb.fitnesstracker.user.internal.UserServiceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsServiceImpl implements StatisticsService, StatisticsProvider {

    private final StatisticsRepository statisticsRepository;

    private final StatisticsMapper statisticsMapper;

    private final UserServiceImpl userService;

    @Override
    public Statistics createStatistics(final InputStatisticsDto inputStatisticsDto) {
        log.info("Creating Statistics {}", inputStatisticsDto);

        Optional<User> user = userService.getUser(inputStatisticsDto.getUserId());

        if (user.isEmpty()) {
            throw new UserNotFoundException(inputStatisticsDto.getUserId());
        }

        return statisticsRepository.save(statisticsMapper.toEntity(inputStatisticsDto, user.get()));
    }

    @Override
    public Statistics updateStatistics(final Long statisticsId, final InputStatisticsDto inputStatisticsDto) {
        log.info("Updating Statistics with ID {}", statisticsId);

        Statistics statistics = statisticsRepository.findById(statisticsId)
                .orElseThrow(() -> new StatisticsNotFoundException(statisticsId));

        statistics.setTotalTrainings(inputStatisticsDto.getTotalTrainings());
        statistics.setTotalDistance(inputStatisticsDto.getTotalDistance());
        statistics.setTotalCaloriesBurned(inputStatisticsDto.getTotalCaloriesBurned());

        return statisticsRepository.save(statistics);
    }

    @Override
    public void deleteStatistics(final Long statisticsId) {
        log.info("Deleting Statistics with ID {}", statisticsId);
        statisticsRepository.deleteById(statisticsId);
    }

    @Override
    public List<Statistics> findAllStatistics() {
        return statisticsRepository.findAll();
    }

    @Override
    public List<Statistics> findStatisticsByUserId(final Long userId) {
        return statisticsRepository.findAllByUserId(userId);
    }

}
