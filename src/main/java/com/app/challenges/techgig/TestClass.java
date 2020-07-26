package com.app.challenges.techgig;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class TestClass {

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
        int[] requiredQuantity = new int[T];
        int[] availableQuantity = new int[T];

        for (int i = 0; i < T; i++) {
            requiredQuantity[i] = sc.nextInt();
        }
        for (int i = 0; i < T; i++) {
            availableQuantity[i] = sc.nextInt();
        }
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < T; i++) {
            min = Math.min(min, availableQuantity[i] / requiredQuantity[i]);
        }

        System.out.println(min);
    }
}

