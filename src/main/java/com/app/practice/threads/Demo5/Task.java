package com.app.practice.threads.Demo5;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.logging.Logger;


public class Task implements Callable<Integer> {

    private static Random random = new Random();
    private static Logger logger = Logger.getLogger(Task.class.getName());

    @Override public Integer call() throws Exception {
        Thread.sleep(3000);
        int val = random.nextInt(10);
        logger.info("Value is: " + val);
        return val;
    }
}
