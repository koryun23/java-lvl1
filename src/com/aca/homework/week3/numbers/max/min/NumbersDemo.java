package com.aca.homework.week3.numbers.max.min;

public class NumbersDemo {
/*
    Create a Numbers class that has number1, number2 and number3 private fields and a constructor that takes 3 numbers and assign them to the mentioned fields.
    Create a max() method that does not take any argument and returns a maximum value out of the 3 object fields.
    Create a min() method that does not take any argument and returns a minimum value out of the 3 object fields.
*/
    public static void main(String[] args) {
        Numbers nums = new Numbers(54, 13, 87);
        System.out.println("Maximum number is " + nums.max());
        System.out.println("Minimum number is " + nums.min());
    }
}
