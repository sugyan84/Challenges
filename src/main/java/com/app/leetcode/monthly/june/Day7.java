package com.app.leetcode.monthly.june;

import java.util.Arrays;


/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that amount.
 * You may assume that you have infinite number of each kind of coin.
 */
public class Day7 {

    public static void main(String[] args) {
        System.out.println("change(5, new int[] { 1, 2, 5 }) = " + change(5, new int[] { 1, 2, 5 }));
    }

    public static int change(int amount, int[] coins) {
        Arrays.sort(coins);

        int[][] dp = new int[coins.length + 1][amount + 1];

        //Fill Zeroes.
        for (int r = 0; r < dp.length; r++) {
            for (int c = 0; c < dp[0].length; c++) {
                dp[r][c] = 0;
            }
        }

        for (int r = 1; r < dp.length; r++) {
            for (int c = 1; c < dp[0].length; c++) {
                if (coins[r - 1] == 1) {
                    dp[r][c] = 1;
                    continue;
                }
                
                dp[r][c] = Math.max(dp[r - 1][c], 1 + dp[r][c - coins[r-1]]);
            }
        }

        return dp[coins.length][amount];
    }
}
