package com.app.testCodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Demo3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        list.add("Sugyan");
        list.add("Sahu");
        list.add(null);
        list.add("Panigrahy");
        list.add(null);

        Map<Integer, String> collect = list.stream()
                .filter(l -> l!=null)
                .collect(Collectors.toMap(l -> l.length(), l -> l.toUpperCase()));

        System.out.println(collect);
    }
}
