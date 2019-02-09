package com.app.practice.threads.Demo3;

import java.util.concurrent.CompletableFuture;


public class Demo {

    public static void main(String[] args) throws Exception{

        for (int i = 0; i < 10; i++) {
            CompletableFuture.supplyAsync(()->getOrder())
                    .thenApply(order->enrichOrder(i));
        }

    }


    private static void getOrder() throws Exception {
        Thread.sleep(30);
        System.out.println("Thread: "+Thread.currentThread().getId()+" completed getOrder() for Id-"+id);
    }

    private static void enrichOrder(int id) throws Exception {
        Thread.sleep(30);
        System.out.println("Thread: "+Thread.currentThread().getId()+" completed enrichOrder() for Id-"+id);
    }

    private static void performPayment(int id) throws Exception {
        Thread.sleep(30);
        System.out.println("Thread: "+Thread.currentThread().getId()+" completed performPayment() for Id-"+id);
    }

    private static void dispatch(int id) throws Exception {
        Thread.sleep(30);
        System.out.println("Thread: "+Thread.currentThread().getId()+" completed dispatch() for Id-"+id);
    }

    private static void sendEmail(int id) throws Exception {
        Thread.sleep(30);
        System.out.println("Thread: "+Thread.currentThread().getId()+" completed sendEmail() for Id-"+id);
    }
}
