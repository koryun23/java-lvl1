package com.aca.homework.week19.job.platform.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public final class UserCreationParams {
    private String firstName;
    private String secondName;
    private String username;

    public UserCreationParams(String firstName, String secondName, String username) {
        Assert.notNull(firstName, "first name should not be null");
        Assert.notNull(secondName, "second name should not be null");
        Assert.notNull(username, "username should not be null");
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreationParams that = (UserCreationParams) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, username);
    }

    @Override
    public String toString() {
        return "UserCreationParams{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
