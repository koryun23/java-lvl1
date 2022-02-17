package com.aca.classwork.week2.userprint;

import java.util.Scanner;

public class UserPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = new String[3];
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter a name");
            String name = scanner.nextLine();
            names[i] = name;

        }
        for (int i = 0; i < 3; i++) {
            waitSecond(1);
            System.out.println(names[i]);
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