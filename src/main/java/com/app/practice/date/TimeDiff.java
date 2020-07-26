package com.app.practice.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.List;


public class TimeDiff {

    public static void main(String[] args) throws InterruptedException {
        LocalDateTime prev = LocalDateTime.now();
        
        Thread.sleep(3090);
        
        LocalDateTime next = LocalDateTime.now();

        Duration between = Duration.between(prev, next);

        List<TemporalUnit> units = between.getUnits();

        System.out.println(ChronoUnit.MILLIS.between(prev, next));
    }
}
