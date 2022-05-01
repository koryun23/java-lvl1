package com.aca.homework.week17.note.facade.user;

import org.springframework.util.Assert;

import java.util.Objects;

public class UserSignUpResponseDto {

    private final String username;

    public UserSignUpResponseDto(String username) {
        Assert.notNull(username, "username should not be null");
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignUpResponseDto that = (UserSignUpResponseDto) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "UserSignUpResponseDto{" +
                "username='" + username + '\'' +
                '}';
    }
}
