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
        this.userRepository = userRepository;
        this.userOrganizationRepository = userOrganizationRepository;
        this.organizationService = organizationService;
    }

    @Override
    public User create(UserCreationParams params) {
        Assert.notNull(params, "params should not be null");
        LOGGER.info("saving a new user according to params - {}", params);
        User user = userRepository.save(new User(
                params.getFirstName(),
                params.getSecondName()
        ));
        LOGGER.info("successfully saved a new user - {}", user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("retrieving an optional of a user having id {}", id);
        Optional<User> userOptional = userRepository.findById(id);
        LOGGER.info("successfully retrieved an optional - {}", userOptional);
        return userOptional;
    }

    @Override
    public User removeUserFromOrganization(Long userId) {
        Assert.notNull(userId, "user id should not be null");
        LOGGER.info("removing a user with id - {} from organization", userId);
        User user = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );
        UserOrganization userOrganization = userOrganizationRepository.findByFirstNameAndSecondName(
                user.getFirstName(),
                user.getSecondName()
        ).get();

        userOrganizationRepository.delete(userOrganization);

        LOGGER.info("successfully deleted user - {} from organizations", user);
        return user;
    }

    @Override
    public boolean userHasJob(Long userId) {
        Assert.notNull(userId, "user id should not be null");
        LOGGER.info("checking if a user with id = {} has a job or not", userId);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        return userOrganizationRepository.findByFirstNameAndSecondName(
                user.getFirstName(),
                user.getSecondName()
        ).isPresent();
    }

    @Override
    public User getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("retrieving a user with id({})", id);
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        LOGGER.info("successfully retrieved a user - {}", user);
        return user;
    }

    @Override
    public List<User> getAllByOrganizationId(Long organizationId) {
        Assert.notNull(organizationId, "organization id should not be null");
        LOGGER.info("retrieving all users working in the organization having id - {}", organizationId);
        List<UserOrganization> userOrganizations = userOrganizationRepository.findAllByOrganizationId(organizationId);
        List<User> users = new LinkedList<>();
        for (UserOrganization userOrganization : userOrganizations) {
            users.add(userRepository.findByFirstNameAndSecondName(
                            userOrganization.getFirstName(),
                            userOrganization.getSecondName()
                    ).orElseThrow(() -> new UserNotFoundException(
                            userOrganization.getFirstName(),
                            userOrganization.getSecondName()))
            );
        }
        return users;
    }

    @Override
    public User registerUserAtOrganization(Long userId, Long organizationId) {
        Assert.notNull(userId, "user id should not be null");
        Assert.notNull(organizationId, "organization id should not be null");
        LOGGER.info("registering a user with id({}) at organization with id({})", userId, organizationId);
        User user = getById(userId);
        Organization organization = organizationService.getById(organizationId);
        userOrganizationRepository.save(new UserOrganization(
                user.getFirstName(), user.getSecondName(), organization
        ));
        LOGGER.info("Successfully registered user - {} at organization - {}", user, organization);
        return user;
    }
}
