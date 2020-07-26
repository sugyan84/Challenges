package com.app.practice.lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class Box {
    
    private String boxName;
    private int boxSize;
    private int rating;

    public void setBoxSize(int x){
        System.out.println("Setting Box size...");
    }
    
    @Override public String toString() {
        return "myBox{" +
                "boxName='" + boxName + '\'' +
                ", boxSize=" + boxSize +
                ", rating=" + rating +
                '}';
    }
}
