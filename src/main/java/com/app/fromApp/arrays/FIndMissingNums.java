package com.app.fromApp.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FIndMissingNums {

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 2, 7, 8, 2, 3, 1 };
        findMissingNums(arr).stream().forEach(System.out::println);
    }

    public static List<Integer> findMissingNums(int[] arr) {
        List<Integer> list = new ArrayList<>();

        if (null == arr || arr.length == 0) {
            return null;
        }

        Arrays.sort(arr);

        int shouldBeNow = 1;
        int prevElement = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != shouldBeNow && arr[i] != prevElement) {
                list.add(shouldBeNow);
            } else {
                shouldBeNow++;
            }
            prevElement = arr[i];
        }

        return list;
    }
}
