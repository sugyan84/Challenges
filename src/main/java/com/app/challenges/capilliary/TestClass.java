package com.app.challenges.capilliary;

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

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            sc.nextInt();

            String s = sc.next();

            process(s);

        }

    }

    private static boolean isVowel(char x) {

        if (x == 'a' ||
                x == 'e' ||
                x == 'i' ||
                x == 'o' ||
                x == 'u') {
            return true;
        } else {
            return false;
        }
    }

    private static void process(final String s) {

        char[] str = s.substring(1).toCharArray();

        String prevOps = "";
        char prevVowel = ' ';

        int consonantCounter = 0;

        StringBuffer bfr = new StringBuffer();

        for (char c : str) {

            if (isVowel(c)) {
                //vowel
                if (prevOps.equalsIgnoreCase("CONSONANT")) {
                    bfr.append(consonantCounter);
                    consonantCounter = 0;
                    prevOps = "VOWEL";
                    prevVowel = c;
                    continue;
                }
                if (c == prevVowel) {
                    //same vowel
                } else {
                    bfr.append(prevVowel);
                }

                prevOps = "VOWEL";
                prevVowel = c;
            } else {
                //consonant
                if (prevOps.equalsIgnoreCase("VOWEL")) {
                    bfr.append(prevVowel);
                    prevOps = "CONSONANT";
                    prevVowel = ' ';
                    continue;
                } else {
                    consonantCounter++;
                }

                prevOps = "CONSONANT";
                prevVowel = ' ';
            }
        }

        if (prevOps.equalsIgnoreCase("VOWEL")) {
            bfr.append(prevVowel);
        } else {
            bfr.append(consonantCounter);
        }
        System.out.println(bfr.insert(0, Character.toUpperCase(s.charAt(0))));
    }
}

