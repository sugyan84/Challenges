package com.app.practice.leetcode._565;

import java.util.Arrays;


class Solution {
    
    private static final int MAX_LOOPS = 1000000000;
    
    public static int arrayNesting(int[] nums) {

        int[] resultArr = new int[nums.length];

        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                //start from index i
                resultArr[i] = compute(nums, i);
            }
        }
        Arrays.sort(resultArr);
        
        return resultArr[resultArr.length-1];
    }

    private static int compute(final int[] nums, final int i) {
        int len = 0;
        int currIndex = -1;
        while (currIndex != i) {
            if (len == 0) {
                currIndex = i;
            }
            currIndex = nums[currIndex];
            len++;

            if (len >= MAX_LOOPS)
                break;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {5,4,0,3,1,6,2};
        arrayNesting(arr);
    }
}
