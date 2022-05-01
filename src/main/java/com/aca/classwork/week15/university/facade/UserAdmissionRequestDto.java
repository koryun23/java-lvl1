package com.aca.classwork.week15.university.facade;

public class UserAdmissionRequestDto {

    private final String firstName;
    private final String secondName;

    public UserAdmissionRequestDto(String firstName, String secondName) {
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
        return "UserAdmissionRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
