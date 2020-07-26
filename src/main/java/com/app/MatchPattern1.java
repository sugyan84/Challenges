package com.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class MatchPattern1 {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;

    public static enum InputType {
        BUFFERED_READER, SCANNER
    }

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

        initializeReaders(InputType.SCANNER);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            String[] arr = new String[N];
            Map<String, List<String>> map = new HashMap<>();

            for (int j = 0; j < arr.length; j++) {
                arr[i] = sc.next();
                prepareMap(map, arr[i]);
            }

            String pattern = sc.next();

            List<String> strings = map.get(pattern.trim());
            if (strings == null) {
                System.out.println("No match found");
            } else {
                strings.stream().forEach(System.out::println);
            }

        }

    }

    private static void prepareMap(final Map<String, List<String>> map, final String s) {
        if (s != null) {
            char[] chars = s.toCharArray();
            StringBuffer sbfr = new StringBuffer();

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 65 && chars[i] <= 90) {
                    sbfr.append(chars[i]);
                }
            }

            if (map != null) {
                map.computeIfPresent(sbfr.toString().trim(), (k, oldVal) -> {
                    oldVal.add(s);
                    return oldVal;
                });
                map.computeIfAbsent(sbfr.toString().trim(), (k) -> {
                    List<String> list = new ArrayList<>();
                    list.add(s);
                    return list;
                });
            }
        }
    }
}

