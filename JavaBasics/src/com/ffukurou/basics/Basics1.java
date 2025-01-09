package com.ffukurou.basics;

public class Basics1 {

    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static int sumNumbers(int num1, int num2) {
        return num1 + num2;
    }


    public static void main(String[] args) {

        // Primitive data types
        int number = 5;
        double decimalNumber = 102.5;
        boolean trueFalse = false;
        char letter = 'L';

        // NON-PRIMITIVE
        String sentence = "This is a print from main!";
        Integer number2 = 5;
        Double double2 = 5.5;
        Boolean boolean2 = false;
        Character character = 'D';

        System.out.println(sentence);
        printMessage("This is a print from the printMessage function...");

        System.out.println(sumNumbers(20, 30));
    }
}