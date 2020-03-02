package com.app.challenges.capilliary._3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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

        int N = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        int x = sc.nextInt();

        int[] costArr = new int[N];

        findMinCosttoReachIndex(N - 1, costArr, arr, k, x);

        System.out.println(costArr[N - 1]);
    }

    private static void findMinCosttoReachIndex(final int index, final int[] costArr, final int[] arr, final int k,
            final int x) {
        if (index > arr.length - 1) {
            return;
        }

        if (index == 0) {
            costArr[index] = 0;
            return;
        }

        if (index > 0) {
            findMinCosttoReachIndex(index - 1, costArr, arr, k, x);

            List<Integer> costList = new ArrayList<>(index + 1);

            int tempCurrIndex = index;
            int counter = 0;
            while (counter < k) {
                tempCurrIndex--;
                if (tempCurrIndex >= 0) {
                    if (arr[index] != arr[tempCurrIndex]) {
                        costList.add(costArr[tempCurrIndex] + x);
                    } else {
                        costList.add(costArr[tempCurrIndex]);
                    }
                }
                counter++;
            }

            Integer minCostToReachCurrIndex = costList.stream().min((i1, i2) -> i1.compareTo(i2)).get();
            costArr[index] = minCostToReachCurrIndex;
        }
    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

