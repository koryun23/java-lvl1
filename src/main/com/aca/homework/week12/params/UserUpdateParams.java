package com.aca.homework.week12.params;

import java.util.Objects;

public class UserUpdateParams {
    private final String username;
    private final String firstName;
    private int age;

    public UserUpdateParams(@NotNull String username, @NotNull String firstName, int age) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(firstName);
        this.username = username;
        this.firstName = firstName;
        setAge(age);
    }

    public void setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Age must be a positive number");
        this.age = age;
    }
}
