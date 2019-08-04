package com.app.testCodes;

public class OOM {

    private OOM object;

    public OOM() {
        this.object = new OOM();
    }
}
