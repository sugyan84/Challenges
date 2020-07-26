package com.app.algos.fizzbuzz;

public class Demo {

    public static void main(String[] args) {
        final String FIZZ = "Fizz";
        final String BUZZ = "Buzz";
        final String FIZZ_BUZZ = "FizzBuzz";

        int[] arr = {54, 83, 90, 100, 9, 45, 25};

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%15==0){
                System.out.println(FIZZ_BUZZ);
            }else if(arr[i]%3==0){
                System.out.println(FIZZ);
            }else if(arr[i]%5==0){
                System.out.println(BUZZ);
            }
        }
    }
}
