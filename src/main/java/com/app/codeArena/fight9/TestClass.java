package com.app.codeArena.fight9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

        initializeReaders(InputType.SCANNER);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            int x = 0;
            int sqr = (int) Math.pow(x, 2);

            while (sqr % M <= N) {
                if (list.size() != 0) {
                    break;
                }
                if (sqr % M == N) {
                    list.add(x);
                    x++;
                    sqr = (int) Math.pow(x, 2);
                } else {
                    x++;
                    sqr = (int) Math.pow(x, 2);
                }
            }

            Collections.sort(list);

            if (list.size() == 0) {
                System.out.println("1");
            } else {
                System.out.println(list.get(0));
            }

        }

    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

