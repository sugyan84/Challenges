package com.app.testCodes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class DateTimeTest {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = now.minusHours(2);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format = localDateTime.format(dtf);

        int hour = localDateTime.getHour();
        /*Date dateInstance = new java.util.Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateInstance);
        cal.add(Calendar.HOUR, -2);
        int i = cal.get(Calendar.HOUR_OF_DAY);
        String format = new SimpleDateFormat("yyyy/MM/dd/hh").format(i);*/

        System.out.println("format = " + format + "/" + hour);
        System.out.println("now = " + now);
    }
}
