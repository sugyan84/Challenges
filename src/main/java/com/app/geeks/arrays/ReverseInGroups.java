package com.app.geeks.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import com.app.TestClass;


/**
 * Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.
 */
public class ReverseInGroups {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static TestClass.InputType type;
    private static PrintStream out;

    public static enum InputType {
        BUFFERED_READER, SCANNER
    }

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

    public static void main(String[] args) throws Exception {

        initializeReaders(TestClass.InputType.SCANNER);

        int T = sc.nextInt();

       
        for (int x = 0; x < T; x++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            int[] arr = new int[N];

            for (int i = 0, j = i + K; i < arr.length; i = j + 1, j = i + K) {
                
            }
        }

    }
}
