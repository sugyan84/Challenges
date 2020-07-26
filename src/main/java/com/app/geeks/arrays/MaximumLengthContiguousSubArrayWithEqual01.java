package com.app.geeks.arrays;

public class MaximumLengthContiguousSubArrayWithEqual01 {

    public static void main(String[] args) {
        int[] arr = { 0, 1 };
        System.out.println(findMaxLength(arr));
    }

    public static int findMaxLength(int[] nums) {
        int lastIndexIncrement = 0;
        int ones = 0;
        int zeroes = 0;
        int maxLength = Integer.MIN_VALUE;

        int[] dp = new int[nums.length];

        if(nums[0]==0) zeroes++;
        else ones++;
        
        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones++;
            } else if (nums[i] == 0) {
                zeroes++;
            }

            if (ones == zeroes) {
                if (i == 1) {
                    dp[i] = 2;
                } else {
                    int distance = i - lastIndexIncrement;
                    dp[i] = distance + dp[lastIndexIncrement];
                    lastIndexIncrement = i;
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }
}
