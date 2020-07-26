package com.app.testCodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Demo100 {
    public static void main(String[] args) {
        int[] ints = sortByHeight(new int[] { -1, 150, 190, 170, -1, -1, 160, 180 });
        Arrays.stream(ints).forEach(System.out::println);
    }

    static int[] sortByHeight(int[] a) {
        if (a.length == 0 || a.length < 0) {
            return a;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1) {
                list.add(a[i]);
            }
        }

        Collections.sort(list);

        int k = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != -1) {
                a[i] = list.get(k++);
            }
        }

        return a;
    }

}
