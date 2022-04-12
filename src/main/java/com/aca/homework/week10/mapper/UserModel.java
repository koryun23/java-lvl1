package com.aca.homework.week10.mapper;

public class UserModel {
    private final String username;
    private final String firstName;

    public UserModel(String username, String firstName) {
        this.username = username;
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }
}
