package com.aca.homework.week17.website.service.impl.user;

import com.aca.homework.week17.website.entity.User;
import com.aca.homework.week17.website.repository.user.UserRepository;
import com.aca.homework.week17.website.service.core.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserService testSubject;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void init() {
        testSubject = new UserServiceImpl(userRepository);
    }

    @Test
    public void testFindByUsernameAndPasswordWhenUserDoesNotExist() {
        Mockito.when(userRepository.findByUsernameAndPassword("john11", "pwd11")).thenReturn(Optional.empty());

        Optional<User> userOptional = testSubject.findUserByUsernameAndPassword("john11", "pwd11");

        Assertions.assertThat(userOptional).isEqualTo(Optional.empty());

        Mockito.verify(userRepository).findByUsernameAndPassword("john11", "pwd11");
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testFindByUsernameAndPasswordWhenUserExists() {
        User user = new User("john11", "John", "Smith", "pwd11");
        user.setId(1L);
        Mockito.when(userRepository.findByUsernameAndPassword("john11", "pwd11")).thenReturn(Optional.of(user));
        Assertions.assertThat(testSubject.findUserByUsernameAndPassword("john11", "pwd11"))
                .isEqualTo(Optional.of(user));
        Mockito.verify(userRepository).findByUsernameAndPassword("john11", "pwd11");
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testFindByIdWhenUserDoesNotExist() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.findById(1L)).isEqualTo(Optional.empty());
        Mockito.verify(userRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testFindByIdWhenUserExists() {
        User user = new User("john11", "John", "Smith", "pwd11");
        user.setId(1L);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Assertions.assertThat(testSubject.findById(1L)).isEqualTo(Optional.of(user));
        Mockito.verify(userRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testGetByIdWhenUserDoesNotExist() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> testSubject.getById(1L));
        Mockito.verify(userRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepository);
    }

    @Test
    public void testGetByIdWhenUserExists() {
        User user = new User("john11", "John", "Smith", "pwd11");
        user.setId(1L);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        Assertions.assertThat(testSubject.getById(1L)).isEqualTo(user);
        Mockito.verify(userRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepository);
    }
}