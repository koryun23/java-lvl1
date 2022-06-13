package com.aca.homework.week19.job.platform.facade.user;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.user.request.UserSignUpRequestDto;
import com.aca.homework.week19.job.platform.service.core.UserCreationParams;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserFacadeImplTest {
    private UserFacade userFacade;

    @Mock
    private UserService userService;

    @BeforeEach
    public void init() {
        userFacade = new UserFacadeImpl(userService);
    }

    @Test
    public void testSignUp() {
        Mockito.when(userService.create(new UserCreationParams(
                "John", "Jackson", "jj"
        ))).thenReturn(new User("John", "Jackson", "jj"));
        UserDetailsDto userDetailsDto = userFacade.signUp(new UserSignUpRequestDto(
                "John", "Jackson", "jj"
        ));
        Assertions.assertThat(userDetailsDto.getFirstName()).isEqualTo("John");
        Assertions.assertThat(userDetailsDto.getSecondName()).isEqualTo("Jackson");
        Assertions.assertThat(userDetailsDto.getUsername()).isEqualTo("jj");
        Mockito.verify(userService).create(new UserCreationParams("John", "Jackson", "jj"));
        Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    public void testGetUserDetailsWhenUserNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.empty());
        UserDetailsDto userDetails = userFacade.getUserDetails(1L);
        Assertions.assertThat(userDetails.getErrors()).isNotEmpty();
        Assertions.assertThat(userDetails.getErrors().get(0)).isEqualTo("User with id(1) not found");
        Mockito.verify(userService).findById(1L);
        Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    public void testGetUserDetailsWhenUserExists() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(
                new User("John", "Jackson", "jj")
        ));
        UserDetailsDto userDetailsDto = userFacade.getUserDetails(1L);
        Assertions.assertThat(userDetailsDto.getErrors()).isNull();
        Assertions.assertThat(userDetailsDto.getFirstName()).isEqualTo("John");
        Assertions.assertThat(userDetailsDto.getSecondName()).isEqualTo("Jackson");
        Assertions.assertThat(userDetailsDto.getUsername()).isEqualTo("jj");
        Mockito.verify(userService).findById(1L);
        Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    public void testOpenToWorkWhenUserNotFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.empty());
        UserDetailsDto userDetailsDto = userFacade.openToWork(1L);
        Assertions.assertThat(userDetailsDto.getErrors()).isNotEmpty();
        Assertions.assertThat(userDetailsDto.getErrors().get(0)).isEqualTo("cannot mark a non-existing user open for job offers");
        Mockito.verify(userService).findById(1L);
        Mockito.verifyNoMoreInteractions(userService);
    }

    @Test
    public void testOpenToWorkWhenUserFound() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(new User("John", "Jackson", "jj")));
        Mockito.when(userService.removeUserFromOrganization(1L)).thenReturn(new User("John", "Jackson", "jj"));
        UserDetailsDto userDetailsDto = userFacade.openToWork(1L);
        Assertions.assertThat(userDetailsDto.getUsername()).isEqualTo("jj");
        Assertions.assertThat(userDetailsDto.getFirstName()).isEqualTo("John");
        Assertions.assertThat(userDetailsDto.getSecondName()).isEqualTo("Jackson");
        Mockito.verify(userService).findById(1L);
        Mockito.verify(userService).removeUserFromOrganization(1L);
        Mockito.verifyNoMoreInteractions(userService);
    }
}