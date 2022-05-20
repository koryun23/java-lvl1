package com.aca.classwork.week15.user.service;

public interface UserService {
    User create(CreateUserParams params);

    User getByUsername(String username);
}
