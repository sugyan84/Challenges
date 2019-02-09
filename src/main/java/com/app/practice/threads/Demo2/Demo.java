package com.app.practice.threads.Demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Demo {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Future<Integer> future = executorService.submit(new Task(new PrinterResource(30)));
        Future<Integer> future2 = executorService.submit(new Task(new PrinterResource(60)));


        System.out.println("30!"+future.get());
        //System.out.println("60!"+future2.get());

       executorService.awaitTermination(3, TimeUnit.SECONDS);
    }
}
