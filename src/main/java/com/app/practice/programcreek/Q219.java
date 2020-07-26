package com.app.practice.programcreek;

/**
 * Check if the integer is pallidrome, without using extra-space or converting to String.
 */
public class Q219 {

    public static void main(String[] args) {
        System.out.println("isPallidrome(12321) = " + isPallidrome(55355));
    }

    private static boolean isPallidrome(int x) {
        boolean status = true;
        int tempVal = x;
        //find no.of digits.
        int noOfZeroes = 1;

        while (tempVal >= 10) {
            tempVal = tempVal / 10;
            noOfZeroes = noOfZeroes * 10;
        }

        int subtractor = noOfZeroes;
        int start = 10;
        while (noOfZeroes > 1) {
            int left = x / noOfZeroes;
            int right = x % start;

            if (left != right) {
                return false;
            }

            int exactSubValue = left * noOfZeroes;
            x = x - exactSubValue;  //remove first digit.
            x = x / 10;             //remove last digit.
            noOfZeroes = noOfZeroes / 100;
            subtractor = subtractor / 10;
        }

        return status;
    }
}
