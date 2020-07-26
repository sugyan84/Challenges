package com.app.codesignal;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println("composeRanges(nums) = " + composeRanges(nums));
    }

    static String[] composeRanges(int[] nums) {
        int startIndex = 0;
        int endIndex = 0;
        List<String> list = new ArrayList<>();

        int i = 0;
        if (nums != null) {

            for (int j = 0; j < nums.length; j++) {
                while (nums[i + 1] == nums[i] - 1 && i < nums.length - 1) {
                    i++;
                }
                //Prepare range
                endIndex = i;
                if (startIndex == endIndex) {
                    list.add(String.valueOf("\"" + nums[endIndex] + "\""));
                } else {
                    list.add(String.valueOf("\"" + nums[startIndex] + "->" + nums[endIndex] + "\""));
                }
                i++;
            }
        }
        return new String[1];
    }

}
