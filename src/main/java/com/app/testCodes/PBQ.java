package com.app.testCodes;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;


public class PBQ {

    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        new Thread(() -> {
            System.out.println("Polling...");
            try {
                Integer poll = queue.take();
                System.out.println("Polled: " + poll);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Sugyan").start();

        Thread.sleep(TimeUnit.SECONDS.toMillis(5));
        System.out.println("Adding to queue");
        //queue.add(1);
    }
}
