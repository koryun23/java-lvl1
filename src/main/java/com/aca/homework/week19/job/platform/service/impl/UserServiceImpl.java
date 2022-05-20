package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.entity.UserOrganization;
import com.aca.homework.week19.job.platform.repository.UserOrganizationRepository;
import com.aca.homework.week19.job.platform.repository.UserRepository;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserCreationParams;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserOrganizationRepository userOrganizationRepository;
    private final OrganizationService organizationService;

    public UserServiceImpl(UserRepository userRepository, UserOrganizationRepository userOrganizationRepository, OrganizationService organizationService) {
        Assert.notNull(userRepository, "user repository should not be null");
        Assert.notNull(userOrganizationRepository, "user organization repository should not be null");
        Assert.notNull(organizationService, "organization service should not be null");
        this.userRepository = userRepository;
        this.userOrganizationRepository = userOrganizationRepository;
        this.organizationService = organizationService;
    }

    @Override
    public User create(UserCreationParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("Saving a new user according to the params - {}", params);
        User user = userRepository.save(new User(
                params.getFirstName(),
                params.getSecondName(),
                params.getUsername()
        ));
        LOGGER.info("Successfully saved a new user - {}", user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Retrieving an optional of a user having an id of {}", id);
        Optional<User> userOptional = userRepository.findById(id);
        LOGGER.info("Successfully retrieved an optional - {}", userOptional);
        return userOptional;
    }

    @Override
    public User removeUserFromOrganization(Long userId) {
        Assert.notNull(userId, "user id should not be null");
        LOGGER.info("Removing a user having an id of {} from the list of workers", userId);
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
        UserOrganization userOrganization = userOrganizationRepository.findByUserUsername(
                user.getUsername()
        ).get();

        userOrganizationRepository.delete(userOrganization);

        LOGGER.info("Successfully deleted user - {} from the list of workers", user);
        return user;
    }

    @Override
    public boolean userHasJob(Long userId) {
        Assert.notNull(userId, "user id should not be null");
        LOGGER.info("Checking if a user with id - {} has a job or not", userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        boolean result = userOrganizationRepository.findByUserUsername(
                user.getUsername()
        ).isPresent();
        LOGGER.info("Result of checking if a user - {} has a job or not - {}", user, result);
        return result;
    }

    @Override
    public User getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Retrieving a user with an id of {}", id);
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        LOGGER.info("Successfully retrieved a user - {}", user);
        return user;
    }

    @Override
    public List<User> getAllByOrganizationId(Long organizationId) {
        Assert.notNull(organizationId, "organization id should not be null");
        LOGGER.info("Retrieving all users working in the organization having id - {}", organizationId);
        List<UserOrganization> userOrganizations = userOrganizationRepository.findAllByOrganizationId(organizationId);
        List<User> users = new LinkedList<>();
        for (UserOrganization userOrganization : userOrganizations) {
            users.add(userRepository.findByUsername(
                            userOrganization.getUser().getUsername()
                    ).orElseThrow(() -> new UserNotFoundException(
                            userOrganization.getUser().getUsername()
            )));
        }
        LOGGER.info("The list of users working in the organization having id - {} is {}", organizationId, users);
        return Collections.unmodifiableList(users);
    }

    @Override
    public User registerUserAtOrganization(Long userId, Long organizationId) {
        Assert.notNull(userId, "user id should not be null");
        Assert.notNull(organizationId, "organization id should not be null");
        LOGGER.info("Registering a user having id - {} at organization having id - {}", userId, organizationId);
        User user = getById(userId);
        Organization organization = organizationService.getById(organizationId);
        userOrganizationRepository.save(new UserOrganization(
                user, organization
        ));
        LOGGER.info("Successfully registered user - {} at organization - {}", user, organization);
        return user;
    }
}
