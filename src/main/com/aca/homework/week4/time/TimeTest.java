package com.aca.homework.week4.time;

public class TimeTest {
    public static void main(String[] args) {
        Time time = new Time(3600+5*60+6);
        System.out.println("Hours: " + time.getHours());
        System.out.println("Minutes: " + time.getMinutes());
        System.out.println("Seconds: " + time.getSeconds());
    }
}
