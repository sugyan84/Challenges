package com.app.fromApp.arrays;

import java.util.Arrays;


public class MergeSortedArrays {

    public static void main(String[] args) {
        int[] A = new int[] { 1, 3, 7, 10, 15, 20, 0, 0, 0, 0 };
        int[] B = new int[] { 2, 4, 9, 16 };
        merge(A, B);
    }

    public static void merge(int[] A, int[] B) {
        int i = A.length - 1;
        int j = B.length - 1;
        int k = A.length + B.length - 1;

        while (i > -1 && j > -1) {
            A[k--] = (A[i] > B[j] ? A[i--] : B[j--]);
        }

        while (j > -1) {
            A[k--] = B[j--];
        }

        Arrays.stream(A).forEach(System.out::println);
        System.out.println();
        Arrays.stream(B).forEach(System.out::println);
    }
}
