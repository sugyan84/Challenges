package com.app.challenges.dsAlgo;

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
        String str = sc.next();

        for (int i = 0; i < T; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            String output = getAllArrangements(str, l, r) ? "Possible" : "Impossible";
            System.out.println(output);

        }

    }

    private static boolean getAllArrangements(String string, int l, int r) {
        Set<String> permute = permute(string.substring(l - 1, r));
        List<String> s = permute.stream()
                .filter(e -> e.length() == string.substring(l - 1, r).length() && isPallindrome(e))
                .collect(Collectors.toList());
        if (s.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isPallindrome(String string) {
        for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    private static Set<String> permute(final String string) {
        Set<String> tempList = new HashSet<>();
        if ((string == null || "".equals(string))) {
            tempList.add("");
            return tempList;
        }

        char x = string.charAt(0);
        String restStr = string.substring(1);
        Set<String> permute = permute(restStr);
        tempList.addAll(permute);
        for (final String s : permute) {
            if (s == "") {
                tempList.add("" + x);
            }
            for (int i = 0; i < s.length() + 1; i++) {
                String formedStr = s.substring(0, i) + x + s.substring(i);
                tempList.add(formedStr);
            }
        }
        return tempList;
    }

    static enum InputType {
        BUFFERED_READER, SCANNER
    }
}

