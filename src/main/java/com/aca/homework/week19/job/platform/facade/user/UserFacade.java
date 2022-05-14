package com.aca.homework.week19.job.platform.facade.user;

import com.aca.homework.week19.job.platform.facade.user.request.UserSignUpRequestDto;

public interface UserFacade {
    UserDetailsDto signUp(UserSignUpRequestDto dto);

    UserDetailsDto getUserDetails(Long userId);

    UserDetailsDto openToWork(Long userId);
}
