package com.aca.homework.week17.website.service.core.user;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UserCreationParams {
    private String username;
    private String firstName;
    private String secondName;
    private String password;

    public UserCreationParams(String username, String firstName, String secondName, String password) {
        Assert.notNull(username, "username should not be null");
        Assert.hasText(username, "username should not be empty");
        Assert.notNull(firstName, "first name should not be null");
        Assert.hasText(firstName, "first name should not be empty");
        Assert.notNull(secondName, "second name should not be null");
        Assert.hasText(secondName, "second name should not be empty");
        Assert.notNull(password, "password should not be null");
        Assert.hasText(password, "password should not be empty");
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreationParams that = (UserCreationParams) o;
        return Objects.equals(username, that.username) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, secondName, password);
    }

    @Override
    public String toString() {
        return "UserCreationParams{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
