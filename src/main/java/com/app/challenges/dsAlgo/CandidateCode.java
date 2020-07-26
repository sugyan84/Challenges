package com.app.challenges.dsAlgo;

/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;


public class CandidateCode {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static TestClass.InputType type;
    private static PrintStream out;

    /**
     * @param pType:
     *         sc for Scanner
     *         br for BufferedReader
     */
    public static void initializeReaders(TestClass.InputType pType) {

        if (pType.equals(TestClass.InputType.BUFFERED_READER)) {
            type = pType;
            br = new BufferedReader(new InputStreamReader(System.in));
        } else if (pType.equals(TestClass.InputType.SCANNER)) {
            type = pType;
            sc = new Scanner(System.in);
        }
        out = System.out;
    }

    public static void main(String args[]) throws Exception {

        //Write code here
        initializeReaders(TestClass.InputType.SCANNER);

        int B = sc.nextInt();
        int N = sc.nextInt();

        int[] beerWeights = new int[B];
        int[] weights = new int[N];

        for (int i = 0; i < B; i++) {
            beerWeights[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }
        Arrays.sort(beerWeights);
        Arrays.sort(weights);

        System.out.println(calculateStrategy(weights, beerWeights));

    }

    private static int calculateStrategy(final int[] weights, final int[] beerWeights) {
        int boxToPick = 0;
        int maxRepeatTours = Integer.MIN_VALUE;
        int maxTourCounter = 0;
        for (int i = 0; i < weights.length; i++) {
            maxTourCounter = 0;
            while (beerWeights[boxToPick] <= weights[i]) {
                boxToPick++;
                maxTourCounter++;
            }
            maxRepeatTours = Math.max(maxRepeatTours, maxTourCounter);
        }
        if (maxRepeatTours == 1) {
            return 1;
        } else {
            return maxRepeatTours + 1;
        }
    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

