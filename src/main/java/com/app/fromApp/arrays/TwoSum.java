package com.app.fromApp.arrays;

import java.util.HashMap;
import java.util.Map;


/**
 * return indices of two numbers which add up to Target num.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 7, 11, 15, 30, 9, 6 };
        int targetNum = 21;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - targetNum);
            final int finalI = i;

            if (map.containsKey(diff)) {
                System.out.println(i + ", " + map.get(diff));
                break;
            } else {
                map.put(arr[i], i);
            }
        }
    }
}
