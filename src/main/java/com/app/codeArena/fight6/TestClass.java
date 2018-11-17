package com.app.codeArena.fight6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class TestClass {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;

    private static long lVaue;
    static Set<Long> set = null;

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

        long myvalue = sc.nextLong();

        long lockValue = sc.nextLong();

        int N = sc.nextInt();

        set = new HashSet<Long>(N);

        for (int i = 0; i < N; i++) {
            long newV = sc.nextLong();
            set.add(newV);
        }

        long rem = lockValue % myvalue;

        if (rem != 0) {
            //not possible
            System.out.println(-1);
            System.exit(0);
        } else {
            long toFInd = lockValue / myvalue;

            findSmallestFactor(toFInd);
        }

    }

    private static void findSmallestFactor(long toFInd) {
        long[] arr = {1,2,3};

        helperMethod(toFInd, 0, arr);
    }

    private static int helperMethod(long toFInd, int index, long[] arr) {

        if (toFInd % arr[index] == 0) {
            //yes
            long left = toFInd / arr[index];

            //set contains left?
                //yes: count time as 2.
                //no: recurse for left and add returned count to 1.

        } else {
            //recurse for next element.
                //return direct result.
           return helperMethod(toFInd, index+1, arr);
        }

        return -1;
    }

}

