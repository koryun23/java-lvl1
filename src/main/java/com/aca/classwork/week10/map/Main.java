package com.aca.classwork.week10.map;

public class Main {
    public static void main(String[] args) {
        User user = new User("username1", 15);
        System.out.println(user.hashCode());

        User user2 = new User("username2", 15);
        System.out.println(user2.hashCode());

        User user3 = new User("username2", 15);
        System.out.println(user3.hashCode());
    }
}
