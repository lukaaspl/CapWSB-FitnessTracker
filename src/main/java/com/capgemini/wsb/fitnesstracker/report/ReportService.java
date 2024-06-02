package com.capgemini.wsb.fitnesstracker.report;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.capgemini.wsb.fitnesstracker.date.DateUtils;
import com.capgemini.wsb.fitnesstracker.mail.api.EmailDto;
import com.capgemini.wsb.fitnesstracker.mail.internal.EmailSenderImpl;
import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.internal.TrainingServiceImpl;
import com.capgemini.wsb.fitnesstracker.user.api.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReportService {

    @Autowired
    private TrainingServiceImpl trainingService;

    @Autowired
    private EmailSenderImpl emailSender;

    @Scheduled(cron = "0 0 0 * * MON") // At 00:00 every Monday
    public void generateWeeklyTrainingReport() {
        Date startOfLastWeek = DateUtils.getStartOfLastWeek();
        Date endOfLastWeek = DateUtils.getEndOfLastWeek();

        List<Training> foundTrainings = trainingService.findTrainingsBetweenDates(
                startOfLastWeek, endOfLastWeek);

        Map<User, List<Training>> trainingsByUser = foundTrainings.stream()
                .collect(Collectors.groupingBy(Training::getUser));

        trainingsByUser.forEach((user, trainings) -> {
            EmailDto emailDto = new EmailDto(user.getEmail(), "Weekly training report",
                    buildWeeklyTrainingReportContent(user, trainings));

            emailSender.send(emailDto);

            log.info("Sending email to {} with subject: {} and content: {}", emailDto.toAddress(), emailDto.subject(),
                    emailDto.content());
        });

    }

    private String buildWeeklyTrainingReportContent(User user, List<Training> trainings) {
        StringBuilder content = new StringBuilder();

        content.append("Hello, ").append(user.getFirstName()).append("!\n\n");
        content.append("Here is the summary of your trainings from the last week:\n\n");

        trainings.forEach(training -> {
            content
                    .append("Training #")
                    .append(training.getId())
                    .append(", date: ")
                    .append(training.getEndTime())
                    .append(", activity type: ")
                    .append(training.getActivityType())
                .append(", performance: ")
                    .append(training.getDistance())
                    .append(" km at ")
                    .append(training.getAverageSpeed())
                    .append(" km/h\n\n");
        });

        content.append("Total trainings: ").append(trainings.size()).append("\n\n");
        content.append("Keep up the good work!");

        return content.toString();
    }

}
