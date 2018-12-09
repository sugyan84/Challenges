package com.app.challenges.thoughtWorks;

import java.util.Arrays;
import java.util.Scanner;


class TestClass {


    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);

        long N = s.nextLong();
        long Q = s.nextLong();

        long[] arr = new long[(int) N];

        for (long i = 0; i < N; i++) {
            arr[(int) i] = s.nextLong();
        }

        Arrays.sort(arr);

        for (long i = 0; i < Q; i++) {
            long q = s.nextLong();
            queryElemment(q, arr);
        }
    }

    private static void queryElemment(long checkElement, long[] arr) {

        long lastLarge = -1;

        for (long i = 0; i < arr.length; i++) {

            if(arr[(int)i] < checkElement)
            {
                continue;
            }
            else if(arr[(int)i] > checkElement)
            {
                lastLarge = arr[(int)i];

                long diff = arr[(int)i] - checkElement;

                if(diff > 1)
                {
                    System.out.println(checkElement+1);
                }
                else
                    continue;
            }
        }

    }

}

