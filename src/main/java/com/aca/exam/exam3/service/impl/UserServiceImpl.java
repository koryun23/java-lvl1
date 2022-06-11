package com.aca.exam.exam3.service.impl;

import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.repository.UserRepository;
import com.aca.exam.exam3.service.core.user.UserCreationParams;
import com.aca.exam.exam3.service.core.user.UserService;
import com.aca.exam.exam3.service.impl.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        Assert.notNull(userRepository, "user repository should not be null");
        this.userRepository = userRepository;
    }

    @Override
    public User create(UserCreationParams params) {
        Assert.notNull(params, "provided params should not be null");
        LOGGER.info("Creating and saving a user according to the params - {}", params);
        User user = new User(
                params.getPassport(),
                params.getFirstName(),
                params.getSecondName()
        );
        userRepository.save(user);
        LOGGER.info("Successfully saved a new user - {}", user);
        return user;
    }

    @Override
    public User getByPassport(String passport) {
        Assert.notNull(passport, "passport should not be null");
        LOGGER.info("Retrieving a User according to the passport - {}", passport);
        User user = userRepository.findByPassport(passport).orElseThrow(() -> new UserNotFoundException(passport));
        LOGGER.info("Successfully retrieved a user - {}", user);
        return user;
    }

    @Override
    public boolean existsWithPassport(String passport) {
        Assert.notNull(passport, "passport should not be null");
        LOGGER.info("checking if a user with passport id {} exists", passport);
        User user = userRepository.findByPassport(passport).orElse(null);
        return user != null;
    }


}
