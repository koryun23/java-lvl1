package com.aca.homework.week1.dayofmonth;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a month number: (1-12)");
        int month = scanner.nextInt();
        System.out.println("Input a year");
        int year = scanner.nextInt();
        //check whether the year is leap or not
        boolean isLeap = (year%4==0) && (year % 100 != 0 || year % 400 == 0);
        int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] months = new String[]{"January","February","March","April","May","June","July", "August", "September", "October", "November", "December"};
        int day;
        if(month==2){
            if(isLeap){
                day = 29;
            }else{
                day = 28;
            }
        }else{
            day = days[month-1];
        }
        System.out.format("%s %d has %d days", months[month-1], year, day);
    }
}
