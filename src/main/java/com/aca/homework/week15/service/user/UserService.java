package com.aca.homework.week15.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {
    private final UserRepository userRepository;
    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository repo) {
        userRepository = repo;
    }

    public User create(UserCreateParams params) {
        LOGGER.debug("Creating a user for the provided creation params " + params);
        User user = new User(params);
        userRepository.save(user);
        LOGGER.debug(String.format("Successfully created a user for the provided creation params - %s, result - %s",
                user, params));
        return user;
    }
}
