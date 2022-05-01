package com.aca.homework.week15.service.user;

import java.util.Objects;

@Table(name = "USERS")
public class User {

    @Column(name = "username")
    private final String username;

    @Column(name = "name")
    private final String name;

    public User(String username, String name) {
        this.username = username;
        this.name = name;
    }

    public User(UserCreateParams params) {
        this.username = params.getUsername();
        this.name = params.getName();
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("USER[username=%s, name=%s]", username, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, name);
    }
}
