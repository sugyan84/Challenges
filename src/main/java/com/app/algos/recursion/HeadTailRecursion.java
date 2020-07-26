package com.app.algos.recursion;

public class HeadTailRecursion {

    public static void recurse(int n) {
        if (n == 0) {
            return;
        }

        recurse(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        recurse(5);
    }
}
