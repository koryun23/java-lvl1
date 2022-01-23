package com.aca.homework.week2.maxmin;

import java.util.Scanner;

public class MaxMinTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number");
        int num1 = scanner.nextInt();
        System.out.println("Enter a number");
        int num2 = scanner.nextInt();
        MaxMin maxmin = getMaxMin(num1, num2);
        printMaxMin(maxmin);
    }
    public static void printMaxMin(MaxMin maxmin){
        System.out.format("Max: %d, Min: %d", maxmin.max, maxmin.min);
    }
    public static MaxMin getMaxMin(long num1, long num2){
        MaxMin maxmin = new MaxMin();
        maxmin.max = num1 > num2 ? num1 : num2;
        maxmin.min = num1 > num2 ? num2 : num1;
        return maxmin;
    }
}
