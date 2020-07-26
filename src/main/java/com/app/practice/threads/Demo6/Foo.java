package com.app.practice.threads.Demo6;

public class Foo {

    private volatile int var = 0;

    public void first() throws InterruptedException {
        synchronized (this) {
            while (var != 0) {
                wait();
            }
            System.out.println("First");
            var++;
            var = var % 3;
            notifyAll();
        }
    }

    public void second() throws InterruptedException {
        synchronized (this) {
            while (var != 1) {
                wait();
            }
            System.out.println("Second");
            var++;
            var = var % 3;
            notifyAll();
        }
    }

    public void third() throws InterruptedException {
        synchronized (this) {
            while (var != 2) {
                wait();
            }
            System.out.println("Third");
            var++;
            var = var % 3;
            notifyAll();
        }
    }
}
