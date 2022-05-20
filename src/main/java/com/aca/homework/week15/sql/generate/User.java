package com.aca.homework.week15.sql.generate;

@Table(name = "users")
public class User {

    @Column(name = "full_name")
    private String name;

    @Column(name = "age")
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
