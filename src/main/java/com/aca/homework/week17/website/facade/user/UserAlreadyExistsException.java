package com.aca.homework.week17.website.facade.user;

public class UserAlreadyExistsException extends RuntimeException{
    public UserAlreadyExistsException(String username) {
        super(String.format("A user with username (%s) already exists", username));
    }
}
