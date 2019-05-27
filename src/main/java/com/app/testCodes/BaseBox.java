package com.app.testCodes;

public class BaseBox {
    
    public static int x;

    public BaseBox() {
        System.out.println("BaseBox");
        x++;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }
}
