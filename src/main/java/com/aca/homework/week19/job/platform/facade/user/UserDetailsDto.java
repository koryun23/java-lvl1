package com.aca.homework.week19.job.platform.facade.user;

import java.util.List;
import java.util.Objects;

public class UserDetailsDto {

    private String firstName;
    private String secondName;

    private List<String> errors;

    public UserDetailsDto(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public UserDetailsDto(List<String> errors) {
        this.errors = errors;
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

    @Override
    public String toString() {
        return "UserDetailsDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", errors=" + errors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsDto that = (UserDetailsDto) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, errors);
    }
}
