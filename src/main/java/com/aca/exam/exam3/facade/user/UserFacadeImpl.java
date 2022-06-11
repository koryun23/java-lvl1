package com.aca.exam.exam3.facade.user;

import com.aca.exam.exam3.entity.User;
import com.aca.exam.exam3.facade.user.requests.GetUserByPassportIdRequestDto;
import com.aca.exam.exam3.facade.user.requests.UserCreationRequestDto;
import com.aca.exam.exam3.facade.user.response.GetUserByPassportIdResponseDto;
import com.aca.exam.exam3.facade.user.response.UserCreationResponseDto;
import com.aca.exam.exam3.service.core.user.UserCreationParams;
import com.aca.exam.exam3.service.core.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class UserFacadeImpl implements UserFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);
    private final UserService userService;

    public UserFacadeImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserCreationResponseDto create(UserCreationRequestDto dto) {
        Assert.notNull(dto, "user creation request dto should not be null");
        User user = userService.create(new UserCreationParams(
                dto.getPassport(),
                dto.getFirstName(),
                dto.getSecondName()
        ));
        return new UserCreationResponseDto(
                user.getFirstName(),
                user.getSecondName(),
                user.getPassport()
        );
    }

    @Override
    public GetUserByPassportIdResponseDto getByPassport(GetUserByPassportIdRequestDto dto) {
        Assert.notNull(dto, "user retrieval by passport request dto should not be null");
        User user = userService.getByPassport(dto.getPassport());
        return new GetUserByPassportIdResponseDto(
                user.getFirstName(),
                user.getSecondName(),
                user.getPassport()
        );
    }
}
