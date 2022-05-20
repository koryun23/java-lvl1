package com.aca.classwork.week15.university.service.core;

import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;

public class CreateUserParams {
    private final String username;
    private final String firstName;
    private final String secondName;
    private final String password;
    private final LocalDate createdAt;

    public CreateUserParams(String username, String password, String firstName, String secondName, LocalDate createdAt) {
        Assert.hasText(firstName, "The first name should not be null");
        Assert.hasText(secondName, "The first name should not be null");
        Assert.hasText(username, "The username should not be null");
        Assert.notNull(createdAt, "creation date should not be null");
        this.createdAt = createdAt;
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateUserParams that = (CreateUserParams) o;
        return Objects.equals(username, that.username) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, secondName, createdAt, password);
    }

    @Override
    public String toString() {
        return "CreateUserParams{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
