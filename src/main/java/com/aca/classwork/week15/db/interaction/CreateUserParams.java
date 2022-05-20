package com.aca.classwork.week15.db.interaction;

public class CreateUserParams {
    private final String firstName;
    private final String secondName;

    public CreateUserParams(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return String.format("PARAMS[first_name=%s, second_name=%s]", firstName, secondName);
    }
}
