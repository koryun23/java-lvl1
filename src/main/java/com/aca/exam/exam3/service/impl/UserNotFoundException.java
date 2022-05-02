package com.aca.exam.exam3.service.impl;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String passport) {
        super(String.format("User with passport '%s' does not exist", passport));
    }
}
