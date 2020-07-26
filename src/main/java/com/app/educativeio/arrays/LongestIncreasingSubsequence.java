package com.app.educativeio.arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = { 4, 2, 3, 6, 10, 1, 12 };

        compute(arr);
    }

    private static int compute(final int[] arr) {
        return recurse(arr, 0, 0, 0, Integer.MIN_VALUE);
    }

    public static int recurse(int[] arr, int currIndex, int maxLen, int currLen, int lastNum) {
        if (currIndex > arr.length) {
            return 0;
        }

        if (arr[currIndex] < lastNum) {
            return maxLen;
        }

        //consider currElemet.
        int newcurrLen = currLen + 1;
        int newmaxLen = maxLen;
        if (newcurrLen > newmaxLen) {
            newmaxLen = newcurrLen;
        }
        return 0;
    }
}
