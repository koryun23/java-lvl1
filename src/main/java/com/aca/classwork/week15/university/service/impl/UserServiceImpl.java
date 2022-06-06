package com.aca.classwork.week15.university.service.impl;

import com.aca.classwork.week15.university.entity.User;
import com.aca.classwork.week15.university.entity.UserRole;
import com.aca.classwork.week15.university.entity.UserRoleType;
import com.aca.classwork.week15.university.repository.UserRepository;
import com.aca.classwork.week15.university.service.core.CreateUserParams;
import com.aca.classwork.week15.university.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        Assert.notNull(userRepository, "user repository cannot be null");
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User create(CreateUserParams params) {
        Assert.notNull(params, "the params cannot be null");
        LOGGER.info("Creating user for the provided params - {}", params);

        String encodedPassword = passwordEncoder.encode(params.getPassword());
        User user = new User(params.getUsername(), encodedPassword, params.getFirstName(), params.getSecondName(), params.getCreatedAt());
        user.setUserRoles(List.of(new UserRole(user, UserRoleType.STUDENT)));

        User savedUser = userRepository.save(user);
        LOGGER.info("Successfully created a user for the provided params - {}, saved user - {}", params, savedUser);
        return savedUser;
    }

    @Override
    public boolean checkCredentials(String username, String password) {
        return userRepository.findByUsername(username)
                .map(user -> user.getPassword())
                .map(encryptedPassword -> passwordEncoder.matches(password, encryptedPassword))
                .orElse(false);
    }

    @Transactional(readOnly = true)
    @Override
    public User getByUsername(String username) {
        Assert.hasText(username, "Username should not be null or empty");
        LOGGER.info("Retrieving user for the provided username - {}", username);

        Optional<User> userOptional = userRepository.findByUsername(username);
        User user = userOptional.orElseThrow(() -> new UserNotFoundException(username));

        LOGGER.info("Successfully retrieved the user for the provided username - {}, result - {}",
                username,
                user);

        return user;
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findByUsername(String username) {
        Assert.hasText(username, "Username should not be null or empty");
        LOGGER.info("Retrieving user for the provided username - {}", username);

        Optional<User> userOptional = userRepository.findByUsername(username);

        LOGGER.info("Successfully retrieved the user for the provided username - {}, result - {}",
                username,
                userOptional);

        return userOptional;
    }

    @Override
    public User getById(Long id) {
        Assert.notNull(id, "The id should not be null");
        LOGGER.info("Retrieving id for the provided username - {}", id);

        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(() -> new UserNotFoundException(id));

        LOGGER.info("Successfully retrieved the user for the provided id - {}, result - {}",
                id,
                user);

        return user;
    }

    @PostConstruct
    public void test() {
        System.out.println("test");
    }
}