package com.aca.classwork.week15.university.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserSignUpResponseDto {
    private String username;
    private String firstName;
    private String secondName;
    private LocalDateTime createdAt;

    public UserSignUpResponseDto() {
    }

    public UserSignUpResponseDto(String username, String firstName, String secondName, LocalDateTime createdAt) {
        this.username = username;
        this.firstName = firstName;
        this.secondName = secondName;
        this.createdAt = createdAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignUpResponseDto that = (UserSignUpResponseDto) o;
        return Objects.equals(username, that.username) && Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, firstName, secondName, createdAt);
    }

    @Override
    public String toString() {
        return "UserSignUpRequestDto{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
