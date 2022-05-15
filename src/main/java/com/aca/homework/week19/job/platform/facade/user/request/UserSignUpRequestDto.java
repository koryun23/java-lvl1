package com.aca.homework.week19.job.platform.facade.user.request;

import org.springframework.util.Assert;

import java.util.Objects;

public class UserSignUpRequestDto {

    private final String firstName;
    private final String secondName;

    public UserSignUpRequestDto(String firstName, String secondName) {
        Assert.notNull(firstName, "first name should not be null");
        Assert.notNull(secondName, "second name should not be null");
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignUpRequestDto that = (UserSignUpRequestDto) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }

    @Override
    public String toString() {
        return "UserSignUpRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
