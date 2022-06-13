package com.aca.homework.week17.website.facade.user;

import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.facade.user.request.UserSignUpRequestDto;
import com.aca.homework.week17.website.facade.user.response.UserSignUpResponseDto;
import com.aca.homework.week17.website.mapper.user.UserSignUpResponseDtoMapper;
import com.aca.homework.week17.website.mapper.user.UserSignUpResponseDtoMapperImpl;
import com.aca.homework.week17.website.service.core.user.UserCreationParams;
import com.aca.homework.week17.website.service.core.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserFacadeTest {

    private UserFacade userFacade;

    @Mock
    private UserService userService;

    @BeforeEach
    public void init() {
        userFacade = new UserFacadeImpl(userService, new UserSignUpResponseDtoMapperImpl());
    }

    @Test
    public void testSignUpFirstTime() {
        Mockito.when(userService.create(new UserCreationParams(
                "johnny11",
                "John",
                "Williams",
                "1234abc"
        ))).thenReturn(new User("johnny11", "John", "Williams", "1234abc"));
        UserSignUpResponseDto signUp = userFacade.signUp(new UserSignUpRequestDto(
                "johnny11",
                "John",
                "Williams",
                "1234abc"
        ));
        Mockito.verify(userService).create(new UserCreationParams(
                "johnny11", "John", "Williams", "1234abc"
        ));
        Assertions.assertThat(signUp.getFirstName()).isEqualTo("John");
        Assertions.assertThat(signUp.getSecondName()).isEqualTo("Williams");
        Assertions.assertThat(signUp.getUsername()).isEqualTo("johnny11");
        Assertions.assertThat(signUp.getPassword()).isEqualTo("1234abc");
    }

    @Test
    public void testSignUpSecondTime() {
        Mockito.when(userService.create(new UserCreationParams(
                "johnny11",
                "John",
                "Williams",
                "1234abc"
        ))).thenReturn(new User("johnny11", "John", "Williams", "1234abc"));
        userFacade.signUp(new UserSignUpRequestDto(
                "johnny11",
                "John",
                "Williams",
                "1234abc"
        ));
        Mockito.when(userService.create(new UserCreationParams(
                "johnny11",
                "John",
                "Williams",
                "1234abc"
        ))).thenThrow(new UserAlreadyExistsException("johnny11"));
        Assertions.assertThatThrownBy(() -> userFacade.signUp(new UserSignUpRequestDto(
                "johnny11",
                "John",
                "Williams",
                "1234abc"
        ))).isExactlyInstanceOf(UserAlreadyExistsException.class);
    }
}