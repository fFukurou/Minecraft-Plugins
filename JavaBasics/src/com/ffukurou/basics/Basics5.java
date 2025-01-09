package com.ffukurou.basics;

import java.util.ArrayList;
import java.util.List;

public class Basics5 {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car());
        vehicleList.add(new Motorbike());


        for (Vehicle vehicle : vehicleList) {
            vehicle.activateBreaks();
        }


        CoffeeSize ordered = CoffeeSize.LARGE;
        System.out.println(ordered.getName() + " " + ordered.getPrice());










    }
}
