package com.app.cars24;

import java.util.Scanner;


class TestClass1 {

    public static void main(String args[]) throws Exception {

        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println("Hi, " + name + ".");*/

        Scanner s = new Scanner(System.in);

        long T = s.nextLong();

        for (long i = 0; i < T; i++) {

            long N = s.nextLong();

            int[] arr = new int[(int) N];

            long sum = 0;

            for (int j = 0; j < arr.length; j++) {
                arr[j] = s.nextInt();
                sum += arr[j];
            }

            double X = sum / N;

            if (X % 1 == 0) {
                int intX = (int)X;
                System.out.println(intX);
            } else {
                System.out.println(-1);
            }

        }
    }
}

