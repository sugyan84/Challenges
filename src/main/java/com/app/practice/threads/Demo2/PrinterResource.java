package com.app.practice.threads.Demo2;

public class PrinterResource {

    int upTo;

    public PrinterResource(final int upTo) {
        this.upTo = upTo;
    }

    public Integer method() {
        int sum=0;
        for (int i = 0; i < upTo; i++) {
            System.out.println(Thread.currentThread().getId() + "\t" + Thread.currentThread().getName() + "\t" + Thread
                    .currentThread().getState() + " --> " + i);
            sum+=i;
        }

        return sum;
    }
}
