package com.app.educativeio.arrays;

public class BracesCombinations {

    public static void main(String[] args) {
        int n = 3;

        compute(n, 0, 0, 0, 0, "");
    }

    private static void compute(final int n, int currIndex, int open, int close, int currLen, String currStr) {
        if (currLen == n * 2) {
            System.out.println(currStr);
            return;
        }

        //consider open brace
        if (open != n || open == close) {
            String c1 = currStr + "(";
            compute(n, currIndex + 1, open + 1, close, currLen + 1, c1);
        }

        //consider close brace
        if (currIndex != 0 && close != n && (open!= close)) {
            String c2 = currStr + ")";
            compute(n, currIndex + 1, open, close + 1, currLen + 1, c2);
        }
    }
}
