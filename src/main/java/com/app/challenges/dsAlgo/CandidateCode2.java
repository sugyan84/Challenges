package com.app.challenges.dsAlgo;

/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;


public class CandidateCode2 {

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
        initializeReaders(TestClass.InputType.SCANNER);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int noOfTeams = sc.nextInt();

            System.out.println(computeNoofMatches(noOfTeams));
        }
    }

    private static int computeNoofMatches(final int noOfTeams) {

        if (noOfTeams == 1) {
            return 0;
        } else if (noOfTeams == 2) {
            return 1;
        } else if (noOfTeams == 3) {
            return 2;
        }

        return 1 + computeNoofMatches(noOfTeams - 1);
    }

    static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

