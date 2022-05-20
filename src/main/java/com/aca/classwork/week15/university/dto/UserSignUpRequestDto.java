package com.aca.classwork.week15.university.dto;

import java.util.Objects;

public class UserSignUpRequestDto {
    private String username;
    private String password;
    private String firstName;
    private String secondName;

    public UserSignUpRequestDto() {
    }

    public UserSignUpRequestDto(String username, String password, String firstName, String secondName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignUpRequestDto that = (UserSignUpRequestDto) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, secondName);
    }

    @Override
    public String toString() {
        return "UserSignUpRequestDto{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
