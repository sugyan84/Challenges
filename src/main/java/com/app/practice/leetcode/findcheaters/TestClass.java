package com.app.practice.leetcode.findcheaters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class TestClass {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;

    /**
     * @param pType:
     *         sc for Scanner
     *         br for BufferedReader
     */
    public static void initializeReaders(InputType pType) {

        if (pType.equals(InputType.BUFFERED_READER)) {
            type = pType;
            br = new BufferedReader(new InputStreamReader(System.in));
        } else if (pType.equals(InputType.SCANNER)) {
            type = pType;
            sc = new Scanner(System.in);
        }
        out = System.out;
    }

    public static void main(String[] args) throws Exception {

        initializeReaders(InputType.BUFFERED_READER);

        String readLine = "";

        Map<Integer, Set<Integer>> map = new HashMap<>();

        while ((readLine = br.readLine()) != null && readLine.length() != 0) {
            String[] split = readLine.split(",");

            Integer key = Integer.parseInt(split[0].trim());
            Integer val = Integer.parseInt(split[1].trim());

            //Adding the numbers to a Map, will print this Map to show a view.
            //This Map holds the linkage between two given roll Numbers.
            map.computeIfPresent(key, (k, v) -> {
                v.add(val);
                return v;
            });

            map.computeIfAbsent(key, (k) -> {
                Set<Integer> list = new HashSet<>();
                list.add(val);
                return list;
            });

            if (map.containsKey(val)) {
                map.get(val).add(key);
            } else {
                Set<Integer> list = new HashSet<>();
                list.add(key);
                map.put(val, list);
            }
        }

        map.entrySet().stream().forEach(System.out::println);
        System.out.println("\n");

        //Traverse the Map and start looking for cheater groups.
        Set<Integer> alreadyEncounteredRollNumbers = new HashSet<>();
        List<Integer> currentGroup = new ArrayList<>();

        map.entrySet().stream().forEach(entry -> {
            findGroup(entry.getKey(), alreadyEncounteredRollNumbers, currentGroup, map);
            Collections.sort(currentGroup);
            currentGroup.stream().forEach(rollNum -> {
                System.out.print(rollNum + ", ");
            });
            System.out.println();
            currentGroup.clear();   //After printing each group, we clear the list to re-use the list.
        });

    }

    private static void findGroup(final Integer key, final Set<Integer> encountered, final List<Integer> list,
            final Map<Integer, Set<Integer>> map) {
        if (!encountered.contains(key)) {
            encountered.add(key);
            list.add(key);
            map.get(key).stream().forEach(subListNum -> findGroup(subListNum, encountered, list, map));
        }
    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

