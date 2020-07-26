package com.app.practice.threads.Demo6;

public class Demo {

    public static void main(String[] args) {
        Foo obj = new Foo();

        TaskExecutor r1 = new TaskExecutor(obj, 0);
        TaskExecutor r2 = new TaskExecutor(obj, 2);
        TaskExecutor r3 = new TaskExecutor(obj, 1);

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();
    }
}
