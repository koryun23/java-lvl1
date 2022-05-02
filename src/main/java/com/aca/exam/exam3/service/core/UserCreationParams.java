package com.aca.exam.exam3.service.core;

import java.util.Objects;

public class UserCreationParams {
    private final String passport;
    private final String firstName;
    private final String secondName;

    public UserCreationParams(String passport, String firstName, String secondName) {
        this.passport = passport;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getPassport() {
        return passport;
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
        UserCreationParams that = (UserCreationParams) o;
        return Objects.equals(passport, that.passport) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport, firstName, secondName);
    }

    @Override
    public String toString() {
        return "UserCreationParams{" +
                "passport='" + passport + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }


}
