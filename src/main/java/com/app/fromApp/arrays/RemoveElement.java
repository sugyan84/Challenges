package com.app.fromApp.arrays;

/**
 * Remove given element from array in-place and return new array and length.
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 5, 3, 9, 2, 3, 3, 4, 5, 3 };

        System.out.println("Original Lenght: " + arr.length);

        int lastIndex = arr.length - 1;
        int excludeVal = 3;

        for (int i = 0; i < lastIndex; i++) {
            if (arr[i] == excludeVal) {
                while (arr[lastIndex] == excludeVal && lastIndex > i) {
                    lastIndex--;
                }
                //swap
                int temp = 0;
                temp = arr[i];
                arr[i] = arr[lastIndex];
                arr[lastIndex] = temp;
                lastIndex--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
