package com.aca.homework.week17.website.mapper.user;

import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.facade.user.response.UserSignUpResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserSignUpResponseDtoMapperImpl implements UserSignUpResponseDtoMapper{

    @Override
    public UserSignUpResponseDto apply(User value) {
        return new UserSignUpResponseDto(
                value.getUsername(),
                value.getFirstName(),
                value.getSecondName(),
                value.getPassword()
        );
    }
}
