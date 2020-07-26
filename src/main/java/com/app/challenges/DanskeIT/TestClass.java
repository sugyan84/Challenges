package com.app.challenges.DanskeIT;

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

        long T = sc.nextLong();

        for (long i = 0; i < T; i++) {
            long num = sc.nextLong();

            convert(num);
        }

    }

    private static void convert(long num) {

        long noOfOpenLanes = 0;

        while (num > 0) {
            long rem = num % 2;

            if (rem == 1) {
                noOfOpenLanes++;
            }

            num = num / 2;
        }

        System.out.println((1 << noOfOpenLanes));
    }
}

