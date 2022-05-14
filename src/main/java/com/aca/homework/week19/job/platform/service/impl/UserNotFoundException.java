package com.aca.homework.week19.job.platform.service.impl;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super(String.format("User with id (%d) not found", id));
    }

    public UserNotFoundException(String firstName, String secondName) {
        super(String.format("User with first name (%s) and second name (%s) not found", firstName, secondName));
    }
}
