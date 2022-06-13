package com.aca.homework.week17.website.service.core.user;

import com.aca.homework.week17.website.entity.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUsernameAndPassword(String username, String password);

    User create(UserCreationParams params);

    User getById(Long id);

    Optional<User> findById(Long id);
}
