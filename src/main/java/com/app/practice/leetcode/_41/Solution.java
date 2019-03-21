package com.app.practice.leetcode._41;

import java.util.Arrays;


class Solution {

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(firstMissingPositive(nums));
    }
    
    public static int firstMissingPositive(int[] nums) {

        int currElem = -1;
        int nextElem = -1;
        int expectingElem = 1;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            currElem = nums[i];
            nextElem = nums[i + 1];

            if (currElem < 0) {
                continue;
            }

            if (currElem > expectingElem) {
                return expectingElem;
            }

            if (currElem == expectingElem || nextElem == expectingElem) {
                expectingElem++;
            }
        }

        return expectingElem;
    }
}
