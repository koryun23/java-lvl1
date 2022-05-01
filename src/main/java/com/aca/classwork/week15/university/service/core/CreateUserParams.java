package com.aca.classwork.week15.university.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserParams that = (CreateUserParams) o;
        return Objects.equals(username, that.username) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, secondName);
    }
}
