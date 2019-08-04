package com.app.testCodes;

import java.util.Objects;


public class Adder implements Runnable {

    int val;
    SharedObject object;

    public Adder(final int valueToAdd, final SharedObject object) {
        this.val = valueToAdd;
        this.object = object;
    }

    @Override
    public void run() {
        if (Objects.nonNull(this.object)) {
            this.object.addValueToTotal(this.val);
        }
    }
}
