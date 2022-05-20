package com.aca.classwork.week15.university.facade.user;

import com.aca.classwork.week15.university.dto.UserSignUpResponseDto;
import com.aca.classwork.week15.university.dto.UserSignUpRequestDto;

public interface UserFacade {
    UserSignUpResponseDto signUp(UserSignUpRequestDto dto);
}
