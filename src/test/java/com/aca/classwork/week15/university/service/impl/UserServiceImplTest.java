package com.aca.classwork.week15.university.service.impl;

import com.aca.classwork.week15.university.entity.User;
import com.aca.classwork.week15.university.repository.UserRepository;
import com.aca.classwork.week15.university.service.core.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void init() {
        userService = new UserServiceImpl(userRepository, passwordEncoder);
    }

    @Test
    public void testCheckCredentialsWhenUserNotFound() {
        Mockito.when(userRepository.findByUsername("javalvl1")).thenReturn(Optional.empty());
        boolean result = userService.checkCredentials("javalvl1", "prof-group");
        Assertions.assertThat(result).isFalse();

        Mockito.verify(userRepository).findByUsername("javalvl1");
        Mockito.verifyNoMoreInteractions(userRepository, passwordEncoder);
    }

    @Test
    public void testCheckCredentialsWhenPasswordWrong() {
        User user = new User();
        user.setPassword("$random-pass");
        Mockito.when(userRepository.findByUsername("javalvl1")).thenReturn(Optional.of(user));
        Mockito.when(passwordEncoder.matches("prof-group", "$random-pass")).thenReturn(false);
        boolean result = userService.checkCredentials("javalvl1", "prof-group");
        Assertions.assertThat(result).isFalse();
        Mockito.verify(userRepository).findByUsername("javalvl1");
        Mockito.verify(passwordEncoder).matches("prof-group", "$random-pass");
        Mockito.verifyNoMoreInteractions(userRepository, passwordEncoder);
    }
}

