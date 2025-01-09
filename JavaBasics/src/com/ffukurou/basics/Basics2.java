package com.ffukurou.basics;

public class Basics2 {
    public static void main(String[] args) {

        boolean sheIsOver18 = true;

        if (sheIsOver18)
            System.out.println("Fair game");
        else
            System.out.println("NO, NO, NO!");


        String string = null;

        try {
        System.out.println(string.substring(0));

        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("OMG BRUHV!");
        }

        System.out.println("Handled the exception!");
    }
}
