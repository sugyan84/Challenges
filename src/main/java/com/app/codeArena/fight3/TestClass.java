package com.app.codeArena.fight3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
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

        //initializeReaders(InputType.BUFFERED_READER);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String nStr = br.readLine();

            if (nStr != null && !nStr.isEmpty()) {
                BigInteger n = new BigInteger(nStr);

                BigInteger val2 = new BigInteger("2");
                BigInteger val3 = new BigInteger("3");
                BigInteger val4 = new BigInteger("4");

                BigInteger by2 = n.divide(val2);
                BigInteger by3 = n.divide(val3);
                BigInteger by4 = n.divide(val4);

                BigInteger divisionSum = new BigInteger("0");

                divisionSum = divisionSum.add(by2).add(by3).add(by4);

                int compareResult = divisionSum.compareTo(n);

                if (compareResult == 1) {
                    System.out.println(divisionSum);
                } else {
                    System.out.println(n);
                }
            } else {
                break;
            }
        }
    }
}

