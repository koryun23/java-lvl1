package com.aca.classwork.week15.user.service;

import org.springframework.util.Assert;

public class CreateUserParams {
    private final String username;
    private final String firstName;
    private final String secondName;

    public CreateUserParams(String username, String firstName, String secondName) {
        Assert.hasText(firstName, "The first name should not be null");
        Assert.hasText(secondName, "The first name should not be null");
        Assert.hasText(username, "The username should not be null");
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "CreateUserParams{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
