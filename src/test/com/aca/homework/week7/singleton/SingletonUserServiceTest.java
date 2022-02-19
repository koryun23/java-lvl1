package com.aca.homework.week7.singleton;

class SingletonUserServiceTest {
    public static void main(String[] args) {
        SingletonUserService user1 = SingletonUserService.getInstance();
        SingletonUserService user2 = SingletonUserService.getInstance();
        SingletonUserService user3 = SingletonUserService.getInstance();
        SingletonUserService user4 = SingletonUserService.getInstance();
        System.out.println(user1 == user2);
        System.out.println(user2 == user3);
        System.out.println(user3 == user4);

    }
}