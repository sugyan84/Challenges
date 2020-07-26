package com.app.practice.threads.Demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class DemoClass {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(executorService.submit(new Task()));
        }

        boolean allDone = false;
        while (allDone) {

        }

        executorService.shutdown();
        System.out.println("ShutDown");

    }
}
