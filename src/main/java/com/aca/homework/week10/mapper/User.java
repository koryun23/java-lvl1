package com.aca.homework.week10.mapper;

public class User {
    private final long id;
    private final String username;
    private final String firstName;

    public User(long id, String username, String firstName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }
}
