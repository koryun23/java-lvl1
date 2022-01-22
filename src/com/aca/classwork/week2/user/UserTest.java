package com.aca.classwork.week2.user;

import java.util.Arrays;
import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        User[] users = new User[3];
        readInput(users);
        printOutput(users);

        User user = searchUser(users, "Ani");
        System.out.format("First name: %s, Last Name: %s, Age: %d\n", user.firstName, user.lastName, user.age);

        String[] names = mapUsersToNames(users);
        System.out.println(Arrays.toString(names));

        int usersAgesSum = usersAgesSum(users);
        System.out.println("Sum of user ages is " + usersAgesSum);
    }

    public static String[] mapUsersToNames(User[] users) {
        String[] names = new String[users.length];
        for (int i = 0; i < users.length; i++) {
            names[i] = users[i].firstName;
        }
        return names;
    }

    public static int usersAgesSum(User[] users) {
        int sum = 0;
        for (User user : users) {
            sum += user.age;
        }
        return sum;
    }

    public static User searchUser(User[] users, String name) {
        for (User user : users) {
            if (user.firstName.equals(name)) {
                return user;
            }
        }
        return new User();
    }

    public static void printOutput(User[] users) {
        for (User user : users) {
            System.out.format("First name: %s, Last Name: %s, Age: %d\n", user.firstName, user.lastName, user.age);
            waitSecond(1);
        }
    }

    public static void readInput(User[] users) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            User user = new User();
            System.out.println("Enter your first Name");
            user.firstName = scanner.next();
            System.out.println("Enter your last name");
            user.lastName = scanner.next();
            System.out.println("Enter your age");
            user.age = scanner.nextInt();
            users[i] = user;
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