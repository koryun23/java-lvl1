package com.aca.homework.week17.website.mapper.user;

import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.facade.post.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapperImpl implements UserDtoMapper {
    @Override
    public UserDto apply(User value) {
        return new UserDto(
                value.getFirstName(),
                value.getSecondName(),
                value.getUsername()
        );
    }
}
