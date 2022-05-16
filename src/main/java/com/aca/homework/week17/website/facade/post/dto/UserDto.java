package com.aca.homework.week17.website.facade.post.dto;

import java.util.Objects;

public class UserDto {
    private final String username;
    private final String firstName;
    private final String secondName;

    public UserDto(String username, String firstName, String secondName) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(username, userDto.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, secondName);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                "firstName='" + firstName + '\'' +
                "secondName='" + secondName + '\'' +
                '}';
    }
}
