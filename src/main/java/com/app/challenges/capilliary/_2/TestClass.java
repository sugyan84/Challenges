package com.app.challenges.capilliary._2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class TestClass {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;
    private static long MOD;

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

    public static void init() {
        MOD = (long) (Math.pow(10, 9) + 7);
    }

    public static void main(String[] args) throws Exception {

        initializeReaders(InputType.SCANNER);
        init();

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            long N = sc.nextLong();
            long[] arr = new long[(int) N];
            long[] sumArr = new long[(int) N];
            long totalSum = 0;

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextLong();
                totalSum += arr[j];

                if (j != 0) {
                    sumArr[j] = sumArr[j - 1] + arr[j];
                } else {
                    sumArr[j] = arr[j];
                }
            }

            int Q = sc.nextInt();
            long[] Larr = new long[Q];
            long[] Rarr = new long[Q];

            for (int j = 0; j < Q; j++) {
                Larr[j] = sc.nextLong() - 1;
            }
            for (int j = 0; j < Q; j++) {
                Rarr[j] = sc.nextLong() - 1;
            }

            for (int j = 0; j < Q; j++) {
                System.out.print((serveForQuery(arr, sumArr, totalSum, Larr[j], Rarr[j]) % MOD) + " ");
            }

        }

    }

    private static long serveForQuery(final long[] arr, final long[] sumArr, final long totalSum, long left,
            long right) {
        long finalSum = 0;

        if (left % arr.length != 0) {
            int startIndex = (int) (left % arr.length);
            int endIndex = (int) arr.length - 1;
            finalSum += sumArr[endIndex] - sumArr[startIndex - 1];
            left = left + (arr.length - startIndex);
        }

        long noOfElements = right - left + 1;
        long extraElements = noOfElements % arr.length;
        long quotient = noOfElements / arr.length;
        if (extraElements != 0) {
            finalSum += (totalSum * quotient) + sumArr[(int) (extraElements - 1)];
        } else {
            finalSum += (totalSum * quotient);
        }

        return finalSum;
    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

