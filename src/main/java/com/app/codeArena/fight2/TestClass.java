package com.app.codeArena.fight2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class TestClass {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;
    private static Map<Character, Integer> initial = new HashMap<Character, Integer>();

    static {
        String ini = "abcdefghijklmnopqrstuvwxyz1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < ini.length(); i++) {
            initial.put(ini.charAt(i), i);
        }
    }

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

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {

            String line = br.readLine();

            String[] listOfStrings = line.split(" ");

            int finalMultiplier = listOfStrings.length;

            int localSum=0;

            for (int currStr = 0; currStr < listOfStrings.length; currStr++) {
                for (int c = 0; c < listOfStrings[currStr].length(); c++) {
                    localSum += c + initial.get(listOfStrings[currStr].charAt(c));
                }
            }

            System.out.println(localSum*finalMultiplier);
        }

    }
}

