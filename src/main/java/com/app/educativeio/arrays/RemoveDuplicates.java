package com.app.educativeio.arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = { 2, 2, 2, 11 };
        System.out.println("remove(arr) = " + remove(arr));
    }

    public static int remove(int[] arr) {
        // TODO: Write your code here
        int lastNum = arr[0];
        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != lastNum) {
                lastNum = arr[i];
                len++;
            }
        }
        return len;
    }
}
