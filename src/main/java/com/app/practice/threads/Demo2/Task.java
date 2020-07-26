package com.app.practice.threads.Demo2;

import java.util.concurrent.Callable;


public class Task implements Callable<Integer> {

    PrinterResource printerResource;

    public Task(final PrinterResource printerResource) {
        this.printerResource = printerResource;
    }

    @Override public Integer call() throws Exception {
        return this.printerResource.method();
    }
}
