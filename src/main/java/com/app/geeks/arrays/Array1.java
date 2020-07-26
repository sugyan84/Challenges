package com.app.geeks.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


/**
 * Subarray with given sum
 * Given an unsorted array A of size N of non-negative integers,
 * find a continuous sub-array which adds to a given number S.
 */
public class Array1 {

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
            int S = sc.nextInt();

            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            int[] compute = compute(arr, S);
            if(compute[0]==0 && compute[1]==0) {
                System.out.println(-1);
            }else {
                for (int j = 0; j < compute.length; j++) {
                    System.out.print(compute[j] + " ");
                }
            }
            System.out.println();
        }

    }

    private static int[] compute(final int[] arr, final int s) {
        int[] ret = new int[2];

        if (arr.length == 0) {
            return ret;
        }

        int start = 0;
        int currSum = 0;

        for (int end = 0; end < arr.length; end++) {
            currSum = currSum + arr[end];

            if (currSum == s) {
                ret[0] = start + 1;
                ret[1] = end + 1;
                return ret;
            }
            
            while (currSum > s) {
                currSum = currSum - arr[start++];

                if (currSum == s) {
                    ret[0] = start + 1;
                    ret[1] = end + 1;
                    return ret;
                }
            }
        }

        return ret;
    }
}
