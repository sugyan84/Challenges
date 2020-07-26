package com.app.educativeio.arrays;

import com.app.utils.RecursionVisualizer;


public class DividaToEqualSumSubset {

    static RecursionVisualizer recursionVisualizer = new RecursionVisualizer();
    
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 6 };

        System.out.println("compute(arr, 0, 0, 0) = " + compute(arr, 0, 0, 0));
    }

    private static boolean compute(int[] arr, int currIndex, int sum1, int sum2) {

        recursionVisualizer.logMethodEntry(String.valueOf(currIndex), String.valueOf(sum1), String.valueOf(sum2));
        
        if (currIndex >= arr.length-1 && sum1 == sum2) {
            recursionVisualizer.logMethodExit(String.valueOf(true));
            return true;
        }

        if (currIndex >= arr.length) {
            recursionVisualizer.logMethodExit(String.valueOf(false));
            return false;
        }

        //Include the item in first subset.
        boolean r1 = compute(arr, currIndex + 1, sum1 + arr[currIndex], sum2);
        boolean r2 = compute(arr, currIndex + 1, sum1, sum2 + arr[currIndex]);

        recursionVisualizer.logMethodExit(String.valueOf(r1 || r2));
        
        return r1 || r2;
    }
}
