package com.app.practice.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


public class Demo {

    public static void main(String[] args) throws ParseException {
        String dateInString = "Jan 29, 2019 12:50:15 GMT";
        String prevString = "Jan 20, 2019 12:50:15 GMT";

        DateFormat formatter = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss z");

        Date latest = formatter.parse(dateInString);
        Date previous = formatter.parse(prevString);

        List<Date> list = new ArrayList<>(2);
        list.add(previous);
        list.add(latest);

        Collections.sort(list, (d1,d2)->{
            return d2.compareTo(d1);
        });

        list.forEach(System.out::println);
    }
}
