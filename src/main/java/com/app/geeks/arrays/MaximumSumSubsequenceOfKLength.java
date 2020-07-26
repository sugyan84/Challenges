package com.app.geeks.arrays;

public class MaximumSumSubsequenceOfKLength {

    static int max_sum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arr = { 8, 5, 9, 10, 5, 6, 21, 8 };
        solve(arr, 0, 0, 3, 0);
        System.out.println(max_sum);
    }

    static void solve(int[] arr, int index, int len, int maxLenAllowed, int currSum) {
        //base condition.
        if (index > arr.length - 1) {
            return;
        }

        if (len == maxLenAllowed) {
            max_sum = Math.max(max_sum, currSum);
            return;
        }

        //consider.
        solve(arr, index + 1, len + 1, maxLenAllowed, currSum + arr[index]);

        //not consider.
        solve(arr, index + 1, len, maxLenAllowed, currSum);
    }
}
