package com.app.practice.threads.Demo6;

public class TaskExecutor implements Runnable {

    private Foo obj;
    private int method;

    public TaskExecutor(final Foo obj, final int methodCaller) {
        this.obj = obj;
        this.method = methodCaller;
    }

    @Override
    public void run() {
        try {
            switch (this.method) {
                case 0:
                    this.obj.first();
                    break;
                case 1:
                    this.obj.second();
                    break;
                case 2:
                    this.obj.third();
                    break;
                default:
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
