package com.aca.homework.week17.website.facade.user.request;

public class UserSignUpRequestDto {
    private final String username;
    private final String firstName;
    private final String secondName;
    private final String password;

    public UserSignUpRequestDto(String username, String firstName, String secondName, String password) {
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

    @Override
    public String toString() {
        return "UserSignUpRequestDto{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
