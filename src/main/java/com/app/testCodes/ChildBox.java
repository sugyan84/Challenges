package com.app.testCodes;

public class ChildBox extends BaseBox {
    
    int y;

    public ChildBox() {
        //super();
        System.out.println("ChildBox");
        x++;
    }

    public ChildBox(final int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }
}
