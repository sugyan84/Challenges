package com.app.challenges.publicisSapient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
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

        initializeReaders(InputType.SCANNER);

        int T = sc.nextInt();
        int[] arr = new int[T];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < T; i++) {
            arr[i] = sc.nextInt();
            final int finalI = i;
            map.computeIfPresent(arr[i], (k, v) -> {
                return v;
            });
        }

    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

