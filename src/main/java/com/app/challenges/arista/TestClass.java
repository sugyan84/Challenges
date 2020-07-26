package com.app.challenges.arista;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
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

        initializeReaders(InputType.BUFFERED_READER);

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine().trim());

            String binaryStr = br.readLine().trim();

            System.out.println(compute(binaryStr));
        }

    }

    private static int compute(final String binaryStr) {
        if (binaryStr != null && binaryStr.length() > 0) {
            char[] arr = binaryStr.toCharArray();

            int windowStart = 0;
            int missed = 0;
            int maxContinuos = Integer.MIN_VALUE;
            int maxTillNow = 0;

            if (arr[0] == '0') {
                missed = 1;
                maxContinuos = 1;
                maxTillNow = 1;
            }

            for (int i = 1; i < arr.length; i++) {
                //include new element.
                if (arr[i] == '1') {
                    maxTillNow++;
                    if (maxTillNow > maxContinuos) {
                        maxContinuos = maxTillNow;
                    }
                } else {
                    missed++;

                    while (missed > 1) {
                        //remove start elemnt.
                        if (arr[windowStart] == '0') {
                            missed--;
                        } else {
                            maxTillNow = maxTillNow - 2;
                        }
                        windowStart++;
                    }
                    
                    /*if (missed == 2) {
                        
                    }*/
                }
            }
            return maxContinuos;
        }
        return 0;
    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

