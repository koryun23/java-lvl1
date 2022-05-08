package com.aca.homework.week17.website.mapper.user;

import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.facade.post.dto.UserDto;
import com.aca.homework.week17.website.mapper.Mapper;

public interface UserDtoMapper extends Mapper<User, UserDto> {
    UserDto apply(User user);
}
