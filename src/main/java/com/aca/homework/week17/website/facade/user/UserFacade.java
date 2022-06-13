package com.aca.homework.week17.website.facade.user;

import com.aca.homework.week17.website.facade.user.request.UserSignUpRequestDto;
import com.aca.homework.week17.website.facade.user.response.UserSignUpResponseDto;

public interface UserFacade {
    UserSignUpResponseDto signUp(UserSignUpRequestDto dto);
}
