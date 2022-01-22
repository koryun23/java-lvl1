package com.aca.classwork.week2.userprint;

import java.util.Scanner;

public class UserPrintWithDetails {
    public static void main(String[] args) {

        String[] firstNames = new String[3];
        String[] secondNames = new String[3];
        int[] ages = new int[3];
        readInput(firstNames, secondNames, ages);

        for (int i = 0; i < 3; i++) {
            waitSecond(1);
            printUserData(firstNames, secondNames, ages, i);

        }
    }

    public static void printUserData(String[] firstNames, String[] secondNames, int[] ages, int i) {
        System.out.format("Name: %s, Last Name: %s, Age: %d\n", firstNames[i], secondNames[i], ages[i]);
    }

    public static void readInput(String[] firstNames, String[] secondNames, int[] ages) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the first name");
            String firstName = scanner.next();
            firstNames[i] = firstName;
            System.out.println("Enter the second name");
            String secondName = scanner.next();
            secondNames[i] = secondName;
            System.out.println("Enter the age");
            int age = scanner.nextInt();
            ages[i] = age;
        }
    }

    public static void waitSecond(int seconds) {
        long startTime = System.currentTimeMillis();
        long lastTime = 0;

        while (lastTime != seconds) {
            long currentSeconds = (System.currentTimeMillis() - startTime) / 1000;
            if (currentSeconds != lastTime) {
                lastTime = currentSeconds;
            }
        }
    }
}
