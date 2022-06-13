package com.aca.homework.week19.job.platform.mapper.user;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.mapper.Mapper;

public interface UserMapper extends Mapper {
    UserDetailsDto map(User user);
}
