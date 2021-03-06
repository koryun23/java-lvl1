package com.aca.classwork.week15.user.service;

import java.util.Optional;

public class OptionalMain {
    public static void main(String[] args) {
        Optional<User> user = getUser();

        user.map(User::getFirstName);

        //user.map(User::getFirstName).ifPresent(System.out::println);
    }

    public static Optional<User> getUser() {
        return Optional.ofNullable(null);
    }
}
