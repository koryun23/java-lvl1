package com.aca.classwork.week8.exception;

public class User {
    private final String username;
    private final String firstName;

    public User(String username, String firstName) {
        if (username == null) {
            throw new IllegalArgumentException("Username is null");
        }

        if (firstName == null) {
            throw new IllegalArgumentException("First name is null");
        }
        this.username = username;
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

}
