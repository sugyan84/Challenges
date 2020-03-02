package com.app.challenges.wissen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


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

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            String source = br.readLine().trim();
            String target = br.readLine().trim();

            System.out.println(compute(source, target));
        }

    }

    private static int compute(final String source, final String target) {
        Map<Character, Integer> sMap = new TreeMap<>();
        Map<Character, Integer> tMap = new TreeMap<>();
        AtomicInteger total = new AtomicInteger(0);

        if (source != null && target != null) {
            for (char x : source.toCharArray()) {
                sMap.computeIfPresent(x, (key, oldVal) -> oldVal + 1);
                sMap.computeIfAbsent(x, (key) -> 1);
            }

            for (char x : target.toCharArray()) {
                tMap.computeIfPresent(x, (key, oldVal) -> oldVal + 1);
                tMap.computeIfAbsent(x, (key) -> 1);
            }

            List<Map.Entry<Character, Integer>> collect1 = sMap.entrySet().stream().collect(Collectors.toList());
            List<Map.Entry<Character, Integer>> collect2 = tMap.entrySet().stream().collect(Collectors.toList());

            tMap.entrySet().stream().forEach(entry -> {
                if (sMap.containsKey(entry.getKey())) {
                    Integer actual = sMap.get(entry.getKey());
                    Integer real = entry.getValue();
                    int min = Math.min(actual, real);
                    total.getAndAdd(min);
                }
            });
        }

        return total.intValue();
    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

