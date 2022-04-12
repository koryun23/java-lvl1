package com.aca.classwork.week10.map;

import java.util.Objects;

public class User {
    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode(){
        return Objects.hash(username, age);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(o instanceof User){
            User other = (User) o;
            return other.getAge() == this.getAge() && other.getUsername().equals(this.getUsername());
        }
        return false;
    }
}
