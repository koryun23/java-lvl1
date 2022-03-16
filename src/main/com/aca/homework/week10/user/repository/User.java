package com.aca.homework.week10.user.repository;

public class User {
    private long id;
    private String username;
    private String firstName;

    public User(long id, String username, String firstName) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj instanceof User) {
            User other = (User) obj;
            return other.id == this.id && other.firstName.equals(this.firstName) && other.username.equals(this.username);
        }
        return false;
    }
}
