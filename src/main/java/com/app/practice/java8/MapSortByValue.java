package com.app.practice.java8;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class MapSortByValue {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 31);
        map.put(10, 13);
        map.put(23, 93);
        map.put(31, 33);
        map.put(12, 21);
        map.put(4, 16);
        map.put(91, 98);
        map.put(1000, 1);

        LinkedHashMap<Integer, Integer> collect = map.entrySet()
                .stream()
                .sorted(comparingByValue())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e2, LinkedHashMap::new));

        collect.forEach((entry, val) -> System.out.println(entry + "=" + val));
    }
}
