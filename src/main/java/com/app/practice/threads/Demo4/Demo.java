package com.app.practice.threads.Demo4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Demo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(4);

        CallableTask task1 = new CallableTask(1000, latch);
        CallableTask task2 = new CallableTask(4000, latch);
        CallableTask task3 = new CallableTask(2000, latch);
        CallableTask task4 = new CallableTask(3000, latch);

        List<CallableTask> list = new ArrayList<>(4);
        list.add(task1);
        list.add(task2);
        list.add(task3);
        list.add(task4);

        /*List<String> collect = executorService.invokeAll(list).stream().map(stringFuture -> {
            String ret=null;
            try {
                ret = stringFuture.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return ret;
        }).collect(Collectors.toList());*/

        Future<String>[] arr = new Future[4];
        final AtomicInteger index = new AtomicInteger();

        list.forEach(t ->
                arr[index.getAndIncrement()] = executorService.submit(t)
        );

        latch.await(2000, TimeUnit.MILLISECONDS); //Waiting for all 4 threads to mark completion using latch or 2sec
        // whichever is earlier.

        System.out.println("All threads completed.");

        System.out.println("\nResults below:\n");
        for (final Future<String> future : arr) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
