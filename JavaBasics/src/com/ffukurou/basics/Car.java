package com.ffukurou.basics;

public class Car extends Vehicle{

    public Car() {
        super(4, "Red");
    }

    public void activateBreaks() {

        System.out.println("CAR STOPPING!");
    }
}
