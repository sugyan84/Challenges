package com.app.testCodes;

import java.util.Map;
import java.util.TreeMap;


public class TreeMapDemo {

    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();

        map.put("Sugyan", 2);
        map.put("Anirban", 7);
        map.put("Bobby", 4);
        map.put("Kiara", 9);
        map.put("Sahu", 1);
        map.put("Tapaswini", 6);

        map.entrySet().stream().sorted((o1, o2) -> o1.getValue().compareTo(o2.getValue())).forEach(System.out::println);
    }
}
