package com.app.testCodes;

import java.util.TreeSet;


public class Demo4 implements I1, I2 {
    public static void main(String[] args) {

        byte a = 6;
        byte b = 10;

        //System.out.println(b == ((b/a)*a+(b%a)));

        long[] x = { 7, 8, 9 };
        long[] y = fix(x);

        System.out.println(x[0] + " " + x[1] + " " + x[2]);
        System.out.println(y[0] + " " + y[1] + " " + y[2]);

        TreeSet<StringBuffer> set = new TreeSet<>();
        set.add(new StringBuffer("fjfkw"));
        set.add(new StringBuffer("fjfkw"));
        set.add(new StringBuffer("fjfkw"));
        set.add(new StringBuffer("fjfkw"));
        set.add(new StringBuffer("fjfkw"));
        set.add(new StringBuffer("fjfkw"));
        set.add(new StringBuffer("fjfkw"));

        System.out.println(set);

    }

    private static long[] fix(final long[] x) {
        x[1] = 4;
        return x;
    }
}


class Hackerearth{
    int a =0;
    
    public Hackerearth(int v){
        a = 1;
    }
}

class Company extends Hackerearth{

    public Company(int v) {
        super(v);
        a = 2;
    }
}
