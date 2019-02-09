package com.app.practice.threads.Demo1;

public class SharedClass {

    public void method() {
        int finalCount =0;

        for (int i = 1; i <= 1000; i++) {
            System.out.println(Thread.currentThread().getName() + " --" + i);
            finalCount = finalCount+i;
        }

        System.out.println(Thread.currentThread().getName() + " -- FinalCount= " + finalCount);
    }
}
