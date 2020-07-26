package com.app.geeks.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import com.app.TestClass;


/**
 * Given arrival and departure times of all trains that reach a railway station.
 * Your task is to find the minimum number of platforms required for the railway station so that no train waits.
 * Note: Consider that all the trains arrive on the same day and leave on the same day.
 * Also, arrival and departure times will not be same for a train,
 * but we can have arrival time of one train equal to departure of the other.
 * In such cases, we need different platforms, i.e at any given instance of time,
 * same platform can not be used for both departure of a train and arrival of another.
 */
public class MinimumPlatforms {
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

        initializeReaders(TestClass.InputType.BUFFERED_READER);

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            
            String[] s1 = br.readLine().trim().split(" ");
            String[] s2 = br.readLine().trim().split(" ");

            
        }

    }
}
