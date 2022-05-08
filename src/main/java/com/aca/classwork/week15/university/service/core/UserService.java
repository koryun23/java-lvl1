package com.aca.classwork.week15.university.service.core;

import com.aca.classwork.week15.university.entity.User;

import java.util.Optional;

public interface UserService {
    User create(CreateUserParams params);

    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    User getById(Long id);
}
