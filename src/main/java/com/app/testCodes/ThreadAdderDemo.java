package com.app.testCodes;

public class ThreadAdderDemo {

    public static void main(String[] args) throws InterruptedException {
        SharedObject sharedObject = new SharedObject();

        Thread t1 = new Thread(new Adder(2, sharedObject));
        Thread t2 = new Thread(new Adder(7, sharedObject));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("sharedObject.getTotal() = " + sharedObject.getTotal());

    }
}
