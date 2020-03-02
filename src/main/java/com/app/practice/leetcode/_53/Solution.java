package com.app.practice.leetcode._53;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class Solution {

    public static void main(String[] args) {
        int[] num = { 0, 2, 0, 2 };
        System.out.println(maxSubArray(num));
    }

    public static int maxSubArray(int[] nums) {

        int maxSum = Integer.MIN_VALUE;
        int windowStart = 0;

        if (nums != null) {
            maxSum = nums[0];
            int sumSoFar = nums[0];

            for (int i = 1; i < nums.length; i++) {
                //Add new element.
                int newElemSum = sumSoFar + nums[i];

                //Remove first element from the window.
                int remElemSum = sumSoFar + nums[i] - nums[windowStart];

                //Consider only current element.
                int currElemSum = nums[i];

                //Find max of these three ways.
                if (newElemSum > remElemSum) {
                    if (newElemSum > currElemSum) {
                        //newElem.
                        sumSoFar = newElemSum;
                    } else {
                        //CurrElem.
                        windowStart = i;
                        sumSoFar = nums[i];
                    }
                } else if (remElemSum > newElemSum) {
                    if (remElemSum > currElemSum) {
                        //RemoveElem.
                        windowStart++;
                        sumSoFar = remElemSum;
                    } else {
                        //CurrElem.
                        windowStart = i;
                        sumSoFar = nums[i];
                    }
                }

                if (sumSoFar > maxSum) {
                    maxSum = sumSoFar;
                }
            }
        }

        return maxSum;
    }
}
