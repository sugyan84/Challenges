package com.app.testCodes;

public class SharedObject {

    private long total;

    public SharedObject() {
    }

    public void addValueToTotal(long valueToBeAdded) {
        synchronized (this) {
            total = total + valueToBeAdded;
        }
    }

    public long getTotal() {
        return total;
    }
}
