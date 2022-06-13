package com.aca.homework.week17.website.service.impl.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super(String.format("user with username (%s) and password (*) not found", username));
    }

    public UserNotFoundException(Long id) {
        super(String.format("user with id (%d) not found", id));
    }
}
