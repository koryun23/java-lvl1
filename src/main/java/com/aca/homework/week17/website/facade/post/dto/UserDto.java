package com.aca.homework.week17.website.facade.post.dto;

import java.util.Objects;

public class UserDto {
    private final String username;

    public UserDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
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
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                '}';
    }
}
