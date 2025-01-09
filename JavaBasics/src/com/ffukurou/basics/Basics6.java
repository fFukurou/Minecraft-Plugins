package com.ffukurou.basics;

import java.util.Calendar;
import java.util.Random;

public class Basics6 {
    public static void main(String[] args) {

        String word = "apple";

        switch (word) {
            case "banana":
                System.out.println("won't print banana");
                break;
            case "apple":
                System.out.println("NOT A PEACH");
                break;
            case "peach":
                System.out.println("PEACH!");
                return;
        }

        System.out.println("bruh");


        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

        cal.add(Calendar.DAY_OF_YEAR, -1);
        System.out.println(cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/"  + cal.get(Calendar.YEAR));

        System.out.println("--------------------------- RANDOMNESS ------------------------------");

        Random random = new Random();
        int rdmNumber = random.nextInt(10);
        System.out.println();

        for (int i = 0; i < rdmNumber; i++) {
            System.out.println(i);
        }
    }
}
