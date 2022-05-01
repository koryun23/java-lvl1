package com.aca.homework.week17.note.service.impl;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super(String.format("User with username %s not found.", username));
    }
}
