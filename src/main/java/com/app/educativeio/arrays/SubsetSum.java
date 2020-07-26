package com.app.educativeio.arrays;

public class SubsetSum {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 8};
        int sum = 6;

        System.out.println("compute(arr) = " + compute(arr, sum));
    }

    private static boolean compute(final int[] arr, final int sum) {

        int windowStart = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            
            while(currSum > sum) {
                currSum = currSum - arr[windowStart++];
                
                if(currSum == sum)
                    return true;
            }
        }

        return false;
    }
}
