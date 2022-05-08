package com.aca.classwork.week15.university.facade;

public class UserGraduationRequestDto {

    private String username;

    public UserGraduationRequestDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return "UserGraduationRequestDto{" +
                "username='" + username + '\'' +
                '}';
    }
}
