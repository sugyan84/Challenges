package com.app.testCodes;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class SortBasedOnFrequency {

    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }

    public static String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        Comparator<Character> comparator = (a, b) -> {
            int compare = map.get(b).compareTo(map.get(a));
            if (compare == 0) {
                return a.compareTo(b);
            } else {
                return compare;
            }
        };

        for (char x : s.toCharArray()) {
            map.computeIfPresent(x, (k, v) -> v + 1);
            map.computeIfAbsent(x, (k) -> 1);
        }
        Map<Character, Integer> treeMap = new TreeMap<>(comparator);
        treeMap.putAll(map);

        StringBuffer sbfr = new StringBuffer();

        treeMap.entrySet().stream().forEach(entry -> {
            for (int i = 0; i < entry.getValue(); i++) {
                sbfr.append(entry.getKey());
            }
        });

        return sbfr.toString();
    }
}
