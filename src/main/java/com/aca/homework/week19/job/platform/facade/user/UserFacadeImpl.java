package com.aca.homework.week19.job.platform.facade.user;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.user.request.UserSignUpRequestDto;
import com.aca.homework.week19.job.platform.service.core.UserCreationParams;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
public class UserFacadeImpl implements UserFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);
    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetailsDto signUp(UserSignUpRequestDto dto) {
        Assert.notNull(dto, "user sign up request dto should not be null");
        LOGGER.info("signing up a new user according to user sign up dto - {}", dto);
        User user = userService.create(new UserCreationParams(
                dto.getFirstName(),
                dto.getSecondName()
        ));
        UserDetailsDto userDetailsDto = new UserDetailsDto(user.getFirstName(), user.getSecondName());
        LOGGER.info("successfully signed up a new user - {}, user details dto - {}", user, userDetailsDto);
        return userDetailsDto;
    }

    @Override
    public UserDetailsDto getUserDetails(Long userId) {
        Assert.notNull(userId, "user id should not be null");
        LOGGER.info("retrieving details of a user with id = {}", userId);
        Optional<User> userOptional = userService.findById(userId);
        if (userOptional.isEmpty()) {
            return new UserDetailsDto(
                    List.of(
                            String.format("User with id(%d) not found", userId)
                    )
            );
        }
        User user = userOptional.get();
        UserDetailsDto userDetailsDto = new UserDetailsDto(
                user.getFirstName(), user.getSecondName()
        );
        LOGGER.info("successfully retrieved details of the user - {}", userDetailsDto);
        return userDetailsDto;
    }

    @Override
    public UserDetailsDto openToWork(Long userId) {
        Assert.notNull(userId, "user id should not be null");
        LOGGER.info("marking a user with id = {} open for job offers", userId);
        if (userService.findById(userId).isEmpty()) {
            return new UserDetailsDto(List.of("cannot mark a non-existing user open for job offers"));
        }
        User user = userService.removeUserFromOrganization(userId);
        UserDetailsDto userDetailsDto = new UserDetailsDto(
                user.getFirstName(),
                user.getSecondName()
        );
        LOGGER.info("user details dto - {}", userDetailsDto);
        return userDetailsDto;
    }
}
