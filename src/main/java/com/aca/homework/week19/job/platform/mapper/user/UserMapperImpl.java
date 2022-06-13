package com.aca.homework.week19.job.platform.mapper.user;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDetailsDto map(User user) {
        return new UserDetailsDto(user.getFirstName(), user.getSecondName(), user.getUsername());
    }
}
