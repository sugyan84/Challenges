package com.app.testCodes;

import java.util.HashSet;
import java.util.Set;


public class Demo989 {

    public static void main(String[] args) {
        int[] arr = { 10, 1, 2, 3, 4, 5 };
        System.out.println("almostIncreasingSequence(arr) = " + almostIncreasingSequence(arr));
    }

    static boolean almostIncreasingSequence(int[] sequence) {
        Set<Integer> set = new HashSet();
        int inc = 0;
        int dec = 0;
        if (sequence != null) {
            for (int i = sequence.length - 1; i > 0; i--) {
                if (sequence[i] > sequence[i - 1]) {
                    inc++;
                } else if (sequence[i] < sequence[i - 1]) {
                    dec++;
                } else {
                    break;
                }
                set.add(sequence[i]);
                set.add(sequence[i - 1]);
            }
        }
        if (inc == 1 && set.size() == sequence.length && dec != 1) {
            return true;
        } else if (dec == 1 && set.size() == sequence.length && inc != 1) {
            return true;
        } else {
            return false;
        }
    }

}
