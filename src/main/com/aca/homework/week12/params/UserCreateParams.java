package com.aca.homework.week12.params;

public class UserCreateParams {
    private String username;
    private String firstName;
    private int age;

    public UserCreateParams(@NotNull String username, @NotNull String firstName, int age) {
        setUsername(username);
        setFirstName(firstName);
        setAge(age);
    }

    public void setUsername(String username) {
        if (username == null)
            throw new IllegalArgumentException("Provided username is null.");
        this.username = username;
    }

    public void setFirstName(String firstName) {
        if (firstName == null)
            throw new IllegalArgumentException("Provided first name is null.");
        this.firstName = firstName;
    }

    public void setAge(int age) {
        if (age < 0)
            throw new IllegalArgumentException("Provided age is negative.");
        this.age = age;
    }
}
