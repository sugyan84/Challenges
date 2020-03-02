package com.app.educativeio.arrays;

import java.util.Arrays;
import java.util.Objects;


/**
 * Move all zeroes to left of array while maintaining the order of non-zero elements.
 */
public class MoveZeroesToLeft {

    public static void main(String[] args) {
        int[] arr = { 1, 10, 20, 0, 59, 63, 0, 88, 0 };

        movesZeroesToLeft(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void movesZeroesToLeft(final int[] arr) {
        int zero = -1;
        int nonZero = -1;
        if (Objects.nonNull(arr)) {
            zero = arr.length - 1;
            nonZero = arr.length - 1;

            for (; zero >= 0; zero--) {
                if (arr[zero] == 0) {
                    nonZero = zero - 1;
                    while (nonZero >= 0 && arr[nonZero] == 0) {
                        nonZero--;
                    }
                    //Swap
                    if (nonZero >= 0) {
                        int temp = arr[nonZero];
                        arr[nonZero] = arr[zero];
                        arr[zero] = temp;
                    }
                }
            }
        }
    }
}
