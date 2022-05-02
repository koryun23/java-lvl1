package com.aca.exam.exam3.facade.user;

import com.aca.exam.exam3.facade.user.requests.GetUserByPassportIdRequestDto;
import com.aca.exam.exam3.facade.user.requests.UserCreationRequestDto;
import com.aca.exam.exam3.facade.user.response.GetUserByPassportIdResponseDto;
import com.aca.exam.exam3.facade.user.response.UserCreationResponseDto;

public interface UserFacade {
    UserCreationResponseDto create(UserCreationRequestDto dto);

    GetUserByPassportIdResponseDto getByPassport(GetUserByPassportIdRequestDto dto);
}
