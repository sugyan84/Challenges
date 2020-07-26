package com.app.fromApp.arrays;

/**
 * Remove duplicate elements from sorted array and return new lenght.
 */
public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };

        System.out.println("Original Lenght: " + arr.length);

        int length = arr.length;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                length--;
            }
        }

        System.out.println("New length: " + length);
    }
}
