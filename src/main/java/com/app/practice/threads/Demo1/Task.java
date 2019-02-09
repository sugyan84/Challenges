package com.app.practice.threads.Demo1;

public class Task implements Runnable {
    SharedClass obj;

    public Task(SharedClass obj){
        this.obj= obj;
    }

    @Override public void run() {
        this.obj.method();
    }
}
