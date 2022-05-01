package com.aca.homework.week17.note.service.impl;

import com.aca.homework.week17.note.entity.User;
import com.aca.homework.week17.note.repository.UserRepository;
import com.aca.homework.week17.note.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        Assert.notNull(userRepository, "user repository should not be null");
        this.userRepository = userRepository;
    }

    @Override
    public User getByUsername(String username) {
        Assert.notNull(username, "username should not be null");
        LOGGER.info("Retrieving a user with username - {}", username);
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
        LOGGER.info("Successfully retrieved a user - {}", user);
        return user;
    }

    @Override
    public User create(UserCreationParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("creating and saving a new user for the provded params - {}", params);
        User user = userRepository.save(
                new User(
                        params.getUsername(),
                        params.getFirstName(),
                        params.getSecondName()
                )
        );
        LOGGER.info("Successfully created and saved a new user - {}", user);
        return user;
    }
}
