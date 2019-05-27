package com.app.practice.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import org.joda.time.Period;


public class Demo2 {

    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);

        System.out.println(zonedDateTime);
        
        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        //allZoneIds.forEach(System.out::println);

        Period period = new Period();
    }
}
