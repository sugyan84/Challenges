package com.app.practice.leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


public class Test {

    public static void main(String[] args) throws ParseException {

        /*String str = TestMagic.CLOSED.toString();

        System.out.println(str);

        String[] strArr=new String[1];

        Set<String> list = new HashSet<String>();
        list.add("Sugyan");
        list.add("Sahu");

        list.toArray(strArr);

        System.out.println(strArr);*/

        String sDate1="2110";
        SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        sft.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date1=sft.parse(sDate1);
        System.out.println(sDate1+"\t"+date1);

        Calendar c = Calendar.getInstance();
        c.setTime(date1);

        List<String> list = new ArrayList<String>();
        list.add("Sugyan");
        list.add("Sahu");

        list.forEach(s -> {
            System.out.println(s.charAt(0));
        });

    }
}

