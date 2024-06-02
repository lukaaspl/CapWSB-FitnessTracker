package com.capgemini.wsb.fitnesstracker.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateUtils {

    public static Date getStartOfLastWeek() {
        LocalDate now = LocalDate.now();
        LocalDate lastMonday = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)).minusWeeks(1);
        LocalDateTime startOfLastMonday = lastMonday.atStartOfDay();
        return Date.from(startOfLastMonday.atZone(ZoneId.of("UTC")).toInstant());
    }

    public static Date getEndOfLastWeek() {
        LocalDate now = LocalDate.now();
        LocalDate lastSunday = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
        LocalDateTime endOfLastSunday = lastSunday.atTime(23, 59, 59);
        return Date.from(endOfLastSunday.atZone(ZoneId.of("UTC")).toInstant());
    }
}