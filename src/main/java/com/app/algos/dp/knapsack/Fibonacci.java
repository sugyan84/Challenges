package com.app.algos.dp.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Fibonacci {

    Map<Integer, Long> memoizeTable;

    public static void main(String[] args) throws IOException {
        Fibonacci obj = new Fibonacci();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter a number to calculate nth fibonacci number: ");
        long num = Long.parseLong(br.readLine().trim());
        System.out.println(obj.dynamicProgrammingApproach((int) num));
    }

    public Fibonacci() {
        this.memoizeTable = new HashMap<Integer, Long>();
        memoizeTable.put(0, (long) 0);
        memoizeTable.put(1, (long) 1);
    }

    public long bruteForceApproach(int number) {

        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        return bruteForceApproach(number - 1) + bruteForceApproach(number - 2);
    }

    public long dynamicProgrammingApproach(int number) {

        if (memoizeTable.containsKey(number)) {
            return memoizeTable.get(number);
        }

        memoizeTable.put(number - 1, dynamicProgrammingApproach(number - 1));
        memoizeTable.put(number - 2, dynamicProgrammingApproach(number - 2));

        memoizeTable.put(number, memoizeTable.get(number - 1) + memoizeTable.get(number - 2));

        return memoizeTable.get(number);
    }

}
