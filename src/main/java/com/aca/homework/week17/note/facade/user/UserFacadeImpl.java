package com.aca.homework.week17.note.facade.user;

import com.aca.homework.week17.note.entity.User;
import com.aca.homework.week17.note.service.core.UserService;
import com.aca.homework.week17.note.service.impl.UserCreationParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class UserFacadeImpl implements UserFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);
    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        Assert.notNull(userService, "user service should not be null");
        this.userService = userService;
    }

    @Override
    public UserSignUpResponseDto signUp(UserSignUpRequestDto dto) {
        Assert.notNull(dto, "user signup request dto should not be null");
        LOGGER.info("signing up a new user according to the signup request dto - {}", dto);
        User user = userService.create(
                new UserCreationParams(
                        dto.getUsername(),
                        dto.getFirstName(),
                        dto.getSecondName()
                )
        );
        LOGGER.info("successfully signed up a new user - {}", user);
        return new UserSignUpResponseDto(user.getUsername());
    }
}
