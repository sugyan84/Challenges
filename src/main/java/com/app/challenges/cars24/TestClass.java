package com.app.challenges.cars24;

import java.util.Scanner;


class TestClass {

    static int count=0;

    public static void main(String args[] ) throws Exception {

        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println("Hi, " + name + ".");*/

        Scanner s = new Scanner(System.in);

        long N = s.nextLong();

        int[] arr = new int[(int)N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        int k = s.nextInt();

        process(arr, k);

        System.out.println(count);

    }

    private static void process(final int[] arr, final int k) {
        String currStr="";
        loop(0, 0, k, currStr, arr);
    }

    private static void loop(int index, int currSize, int k, String currStr, int[] arr) {

        if(currSize==k){
            //System.out.println(currStr);
            count++;
            return;
        }

        if(index>=arr.length)
            return;


        //don't consider current index's element
        if(index+1>=0 && index+1<arr.length)
        loop(index+1, currSize, k, currStr, arr);


        if(currSize==0 && arr[index]==0)
            return;

        //consider current index's element
        if(index+1>=0 && index+1<arr.length || (index>=0 && index<arr.length))
        loop(index+1, currSize+1, k, currStr+arr[index], arr);

    }

}
