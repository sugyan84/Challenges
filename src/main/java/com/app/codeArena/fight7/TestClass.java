package com.app.codeArena.fight7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;


public class TestClass {

    private static BufferedReader br = null;
    private static Scanner sc = null;
    private static InputType type;
    private static PrintStream out;

    private static Set<String> list = new HashSet<>();

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

    public static void method(int currLength, int maxLength, String currStr) {

        if (currLength != maxLength) {
            method(currLength + 1, maxLength, currStr + 'X');
            method(currLength + 1, maxLength, currStr + 'Y');
        } else {
            list.add(currStr);
        }
    }

    public static void main(String[] args) throws Exception {

        initializeReaders(InputType.BUFFERED_READER);

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int P = Integer.parseInt(s[1]);

            method(0, N, "");

            //System.out.println("List:\n");
            //list.forEach(System.out::println);

            final List<String> stringList = list.stream().filter(str -> leadingXLetters(str))
                    .filter(str -> consecutiveP(str, P))
                    .collect(Collectors.toList());

            System.out.println(stringList.size());
        }



    }

    private static boolean consecutiveP(final String str, int P) {
        int count = 0;
        boolean retVal = true;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'X') {
                count++;
                if (count == P) {
                    retVal = false;
                    break;
                }
            } else {
                count = 0;
            }
        }
        return retVal;
    }

    private static boolean leadingXLetters(final String str) {
        boolean yEncountered = false;
        boolean retval = true;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'Y') {
                yEncountered = true;
                continue;
            } else {
                if (yEncountered == false) {
                    retval = false;
                    break;
                }
            }
        }
        return retval;
    }
}

