package com.app.practice.leetcode._53;

import java.util.ArrayList;
import java.util.List;


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
        int[] num = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(num));
    }

    public static int maxSubArray(int[] nums) {

        int j = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            //Add next
            int next = sum + nums[i];
            int prev = sum - nums[j];

            if (next > prev || (next == prev)) {
                list.add(nums[i]);
                sum = sum + nums[i];
            } else if (prev > next) {
                if (list.size() > 0) {
                    list.remove(0);
                }
                sum = sum - nums[j];
                j++;
            }
        }
        System.out.println("list = " + list);
        return sum;
    }
}
