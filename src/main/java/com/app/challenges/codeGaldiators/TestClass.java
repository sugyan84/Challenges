package com.app.challenges.codeGaldiators;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
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

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int[] villians = new int[N];
            int[] heroes = new int[N];

            for (int j = 0; j < N; j++) {
                villians[j] = sc.nextInt();
            }


            for (int j = 0; j < N; j++) {
                heroes[j] = sc.nextInt();
            }

            Arrays.sort(villians);
            Arrays.sort(heroes);

            for (int j = 0; j < N; j++) {
                if(heroes[j] < villians[j]){
                    System.out.println("LOSE");
                    return;
                }
            }
            System.out.println("WIN");
        }

    }
}

