package com.app.algos.dp.lcs;

import com.app.utils.RecursionVisualizer;


/**
 * Find longest common subsequence.
 * X: ABCBDAB
 * Y: BDCABA
 */
public class LongestCommonSubSequence {

    private static RecursionVisualizer visualizer = new RecursionVisualizer();

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";

        visualizer.setExitEncloserType(RecursionVisualizer.ExitEncloserType.CURLY_BRACES);

        System.out.println(getLCSLength(X, Y, X.length(), Y.length()));
    }

    public static int getLCSLength(String X, String Y, int m, int n) {

        visualizer.logMethodEntry(X.substring(0,m),Y.substring(0,n), String.valueOf(m), String.valueOf(n));

        // return if we have reached the end of either sequence
        if (m == 0 || n == 0) {
            visualizer.logMethodExit(String.valueOf(0));
            return 0;
        }

        // if last character of X and Y matches
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            int com = getLCSLength(X, Y, m - 1, n - 1);
            visualizer.logMethodExit(String.valueOf(com+1));
            return com + 1;
        }

        // else if last character of X and Y don't match
        int one = getLCSLength(X, Y, m, n - 1);
        int two = getLCSLength(X, Y, m - 1, n);
        int max = Integer.max(one, two);

        visualizer.logMethodExit(String.valueOf(max));

        return max;
    }
}
