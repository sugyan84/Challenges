package com.app.codeArena.fight4;

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

        long N = sc.nextLong();

        long[] arr = new long[(int) N];

        long[] evenCountTracker = new long[(int) N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLong();

            if (isEven(arr[i])) {
                if (i == 0) {
                    evenCountTracker[i] = 1;
                } else {
                    evenCountTracker[i] = evenCountTracker[i - 1] + 1;
                }
            } else {
                if (i == 0) {
                    evenCountTracker[i] = 0;
                } else {
                    evenCountTracker[i] = evenCountTracker[i - 1];
                }
            }
        }

        long Q = sc.nextLong();

        for (int i = 0; i < Q; i++) {
            int ops = sc.nextInt();
            long left = sc.nextLong();
            long right = sc.nextLong();

            left--;
            right--;
            switch (ops) {
                case 0:
                    long indexUpdate = sc.nextLong();
                    long targetNumber = sc.nextLong();
                    arr[(int) indexUpdate-1] = targetNumber;
                    //revampArr(arr);
                    break;
                case 1:
                    System.out.println(evenCountTracker[(int) right] - evenCountTracker[(int) left]);
                    break;
                case 2:
                    long evenElem = evenCountTracker[(int) right] - evenCountTracker[(int) left];
                    System.out.println(right - left + 1 - evenElem);
                    break;
            }
        }

        /*for (int i = 0; i < evenCountTracker.length; i++) {
            System.out.print(evenCountTracker[i] + " ");
        }*/
    }

    private static boolean isEven(long n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
