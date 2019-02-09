package com.app.algos.recursion;

public class NumberAddition {

    public static int iterative(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static int recursive(int n){
        if(n==1)
            return 1;

        return n+recursive(n-1);
    }
    public static void main(String[] args) {
        System.out.println(iterative(5));
        System.out.println(recursive(5));
    }
}
