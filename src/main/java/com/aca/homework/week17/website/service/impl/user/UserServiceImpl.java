package com.aca.homework.week17.website.service.impl.user;

import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.repository.user.UserRepository;
import com.aca.homework.week17.website.service.core.user.UserCreationParams;
import com.aca.homework.week17.website.service.core.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByUsernameAndPassword(String username, String password) {
        Assert.hasText(username, "username should not be null and should contain 1+ symbols");
        Assert.hasText(password, "password should not be null and should contain 1+ symbols");
        LOGGER.info("retrieving a user optional according to username and password");
        Optional<User> optionalUser = userRepository.findByUsernameAndPassword(username, password);
        LOGGER.info("successfully retrieved a user optional - {}", optionalUser);
        return optionalUser;
    }

    @Override
    public User create(UserCreationParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("creating and saving a user according to the params - {}", params);
        User user = userRepository.save(new User(
                params.getUsername(),
                params.getFirstName(),
                params.getSecondName(),
                params.getPassword()
        ));
        LOGGER.info("successfully saved a new user - {}", user);
        return user;
    }

    @Override
    public User getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("retrieving a user with id = {}", id);
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        LOGGER.info("successfully retrieved a user - {}", user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("retrieving an optional of a user having id {}", id);
        Optional<User> optionalUser = userRepository.findById(id);
        LOGGER.info("successfully retrieved the optional - {}", optionalUser);
        return optionalUser;
    }
}
