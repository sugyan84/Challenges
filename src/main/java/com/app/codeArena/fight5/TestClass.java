package com.app.codeArena.fight5;

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

        initializeReaders(InputType.BUFFERED_READER);

        String line = br.readLine().trim();

        String[] arr = line.split(" ");

        BigInteger a = new BigInteger(arr[0]);

        BigInteger b = new BigInteger(arr[1]);

        BigInteger result = new BigInteger("1");

        BigInteger one = BigInteger.ONE;
        BigInteger two = one.add(BigInteger.ONE);

        result = a.multiply(a);

        for (BigInteger i = two; i.compareTo(b) != 0; i = i.add(one)) {
            result = result.multiply(a);
        }

        BigInteger mod = new BigInteger("1000000007");

        System.out.println(result.mod(mod));
    }
}

