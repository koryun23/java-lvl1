package com.aca.homework.week1.dayofweek;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args){
        System.out.println("Enter a number between 1 and 7 inclusively.");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n < 1 || n > 7){
            System.out.println("Invalid input.");
        }else {
            dayOfWeek(n);
        }
    }
    public static void dayOfWeek(int n){
        String[] days = new String[]{"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        System.out.println(days[n-1]);
    }
}
