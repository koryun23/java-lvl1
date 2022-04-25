package com.aca.classwork.week15.db.interaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(CreateUserParams params) {
        LOGGER.debug("Creating user for the provided params - {}", params);
        User user = new User(params.getFirstName(), params.getSecondName());
        User savedUser = userRepository.save(user);
        LOGGER.debug("Successfully created a user for the provided params - {}", params);
        return savedUser;
    }
}
