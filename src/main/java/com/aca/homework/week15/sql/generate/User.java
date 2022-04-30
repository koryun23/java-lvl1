package com.aca.homework.week15.sql.generate;

@Table(name = "users")
public class User {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "age")
    private Integer age;

    public User(String fullName, Integer age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getName() {
        return fullName;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString(){
        return String.format("USER[name=%s, age=%d]", fullName, age);
    }
}
