package com.app.practice.threads.Demo1;

/*
This program  demonstrates behaviour of a instance method of a stateless object in
multi-threaded environment.

Mutiple Threads can execute simultaneously without corrupting the result
as there is no state/common shared resource.
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        SharedClass sharedClass = new SharedClass();

        //sharedClass.method();

        Task r = new Task(sharedClass);

        Thread t1 = new Thread(r, "Thread-1");
        Thread t2 = new Thread(r, "Thread-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }
}
