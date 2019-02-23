package com.app.practice.threads.Demo4;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;


public class CallableTask implements Callable<String> {

    long timeToExecute;
    CountDownLatch latch;

    public CallableTask(final long timeToExecute, CountDownLatch latch) {
        this.timeToExecute = timeToExecute;
        this.latch = latch;
    }

    @Override public String call() throws Exception {

        Thread.sleep(timeToExecute);
        System.out.println(Thread.currentThread().getId()+" completed.");
        latch.countDown();
        return "ReturnString:"+timeToExecute;
    }
}
