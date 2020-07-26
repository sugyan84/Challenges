package com.app.challenges.americanExpressIntern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class TestClass {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;

    private static enum InputType {
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
            int P = sc.nextInt();

            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            process(arr, P);
        }

    }

    private static void process(final int[] arr, final int P) {

        int startIndex = 0;
        int endIndex = arr.length - 1;
        int minDiff = Integer.MAX_VALUE;

        int k = 1;

        for (int i = 0; i < arr.length; i++) {
            int diffIncluded = Math.abs(P - (k = k & arr[i]));
            int diffExcluded = Integer.MAX_VALUE;
            if (i != 0) {
                diffExcluded = Math.abs(P - (k = (arr[i] & arr[i - 1])));
            }

            int min = Math.min(diffExcluded, diffIncluded);

            if (min < minDiff) {
                minDiff = min;
            }
        }

        System.out.println(minDiff);
    }
}

