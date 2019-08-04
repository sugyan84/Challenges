package com.app.codeArena.fight8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


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
            int[] arr = new int[N];
            Map<Integer, Integer> map = new TreeMap<>((k1, k2) -> k2.compareTo(k1));
            for (int j = 0; j < N; j++) {
                arr[i] = sc.nextInt();
                map.computeIfPresent(arr[i], (key, OldVal) -> 1 + OldVal);
                map.computeIfAbsent(arr[i], integer -> 1);
            }

            while (map.size() > 0) {
                if (map.containsKey(N)) {
                    int tmpVal = map.get(N);
                    map.remove(N);
                    N = N - tmpVal;
                    continue;
                } else {
                    break;
                }
            }

            if (map.size() == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }

    private static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

