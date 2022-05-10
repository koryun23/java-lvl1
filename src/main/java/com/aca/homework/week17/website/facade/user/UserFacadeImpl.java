package com.aca.homework.week17.website.facade.user;

import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.facade.user.request.UserSignUpRequestDto;
import com.aca.homework.week17.website.facade.user.response.UserSignUpResponseDto;
import com.aca.homework.week17.website.service.core.user.UserCreationParams;
import com.aca.homework.week17.website.service.impl.user.UserNotFoundException;
import com.aca.homework.week17.website.service.core.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

public class UserFacadeImpl implements UserFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);
    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        Assert.notNull(userService, "user service should not be null");
        this.userService = userService;
    }

    @Override
    public UserSignUpResponseDto signUp(UserSignUpRequestDto dto) {
        Assert.notNull(dto, "user sign up request dto should not be null");
        LOGGER.info("Signing up a new user according to the user sign up request dto - {}", dto);
        Optional<User> userOptional = userService.findUserByUsernameAndPassword(dto.getUsername(), dto.getPassword());
        if (userOptional.isPresent()) {
            return new UserSignUpResponseDto(List.of(String.format("User with username %s already exists", dto.getUsername())));
        }
        User user = userService.create(new UserCreationParams(
                dto.getUsername(),
                dto.getFirstName(),
                dto.getSecondName(),
                dto.getPassword()
        ));
        UserSignUpResponseDto userSignUpResponseDto = new UserSignUpResponseDto(
                user.getUsername(),
                user.getFirstName(),
                user.getSecondName(),
                user.getPassword()
        );
        LOGGER.info("successfully signed up a new user - {}, response - {}", user, userSignUpResponseDto);
        return userSignUpResponseDto;
    }


}
