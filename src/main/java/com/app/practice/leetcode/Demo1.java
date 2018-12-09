package com.app.practice.leetcode;

import java.util.HashMap;
import java.util.Map;


public class Demo1 {

    private static int[] arr;

    private static int targetSum;

    public static void main(String[] args) {

        targetSum = 13;

        arr = new int[] { 7, 5, 3, 9, 14, 10, 11, 4, 2, 12 };

        twoSum(targetSum);
    }

    private static void twoSum(int targetSum) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {

            if (map.containsKey(arr[i])) {
                System.out.println(map.get(arr[i]) + " " + i);
            } else {
                map.put(targetSum - arr[i], i);
            }
        }

    }
}
