package com.app.testCodes;

public class BaseBox {
    
    public static int x;
    int baseInt = 5;

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
