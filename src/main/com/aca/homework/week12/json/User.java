package com.aca.homework.week12.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("username")
    private String userName;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private int age;

    public User(String userName, String name, int age){
        this.userName = userName;
        this.name = name;
        this.age = age;
    }
}
