package com.aca.homework.week3.numbers.max.min;

public class NumbersDemo {
    public static void main(String[] args) {
        Numbers nums = new Numbers(54, 13, 87);
        System.out.println("Maximum number is " + nums.max());
        System.out.println("Minimum number is " + nums.min());
    }
}
