package com.app.challenges.ninjacart;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;


public class TestClass2 {

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

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();

            int[][] arr = new int[n][3];

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            /*for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.print(arr[j][k]+" ");
                }
                System.out.println();
            }*/
            int currSum = 0;
            int currTileIndex = 0;
            int maxSumTillNow = 0;

            int answer = compute(arr, currSum, currTileIndex);

            System.out.println(answer);
        }

    }

    private static int compute(final int[][] arr, int currSum, int currTileIndex) {
        if (currTileIndex >= arr.length) {
            return currSum;
        }

        Arrays.sort(arr[currTileIndex]);

        //Consider Smallest element from curr Tile.
        int smallest = compute(arr, currSum + arr[currTileIndex][0], currTileIndex + 1);

        //Cosnider mid.
        int mid = compute(arr, currSum + arr[currTileIndex][1], currTileIndex + 2);

        //Consider Largest.
        int largest = compute(arr, currSum + arr[currTileIndex][2], currTileIndex + 3);

        int[] sort = new int[3];
        sort[0] = smallest;
        sort[1] = mid;
        sort[2] = largest;

        Arrays.sort(sort);

        return sort[2];
    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

