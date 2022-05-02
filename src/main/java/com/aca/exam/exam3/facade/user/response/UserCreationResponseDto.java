package com.aca.exam.exam3.facade.user.response;

import java.util.Objects;

public class UserCreationResponseDto {
    private final String firstName;
    private final String secondName;
    private final String passport;

    public UserCreationResponseDto(String firstName, String secondName, String passport) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.passport = passport;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCreationResponseDto that = (UserCreationResponseDto) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(passport, that.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, passport);
    }

    @Override
    public String toString() {
        return "UserCreationResponseDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
