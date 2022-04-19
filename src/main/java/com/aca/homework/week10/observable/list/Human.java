package com.aca.homework.week10.observable.list;

public class Human {

    private final String firstName;
    private final String lastName;

    public Human(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}