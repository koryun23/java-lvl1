package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.entity.UserOrganization;
import com.aca.homework.week19.job.platform.repository.UserOrganizationRepository;
import com.aca.homework.week19.job.platform.repository.UserRepository;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    private UserService testSubject;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserOrganizationRepository userOrganizationRepository;

    @Mock
    private OrganizationService organizationService;

    @BeforeEach
    public void init() {
        testSubject = new UserServiceImpl(userRepository, userOrganizationRepository, organizationService);
    }

    @Test
    public void testGetByIdWhenUserDoesNotExist() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> testSubject.getById(1L)).isExactlyInstanceOf(UserNotFoundException.class);
        Mockito.verify(userRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepository, userOrganizationRepository, organizationService);
    }

    @Test
    public void testFindByIdWhenUserDoesNotExist() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.findById(1L)).isEqualTo(Optional.empty());
        Mockito.verify(userRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepository, userOrganizationRepository, organizationService);
    }

    @Test
    public void testGetByIdWhenUserExists() {
        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.of(new User("John", "Williams", "john11")));
        Assertions.assertThat(testSubject.getById(1L)).isEqualTo(
                new User("John", "Williams", "john11")
        );
        Mockito.verify(userRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepository, userOrganizationRepository, organizationService);
    }

    @Test
    public void testFindByIdWhenUserExists() {
        Mockito.when(userRepository.findById(1L))
                .thenReturn(Optional.of(new User("John", "Williams", "john11")));
        Assertions.assertThat(testSubject.findById(1L)).isEqualTo(
                Optional.of(new User("John", "Williams", "john11"))
        );
        Mockito.verify(userRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepository, userOrganizationRepository, organizationService);
    }

    @Test
    public void testUserHasJobWhenUserIsUnemployed() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(new User("John", "Williams", "john11")));
        Mockito.when(userOrganizationRepository.findByUserUsername("john11")).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.userHasJob(1L)).isEqualTo(false);
        Mockito.verify(userRepository).findById(1L);
        Mockito.verify(userOrganizationRepository).findByUserUsername("john11");
        Mockito.verifyNoMoreInteractions(userRepository, userOrganizationRepository, organizationService);
    }

    @Test
    public void testUserHasJobWhenUserIsEmployed() {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(new User("John", "Williams", "john11")));
        Mockito.when(userOrganizationRepository.findByUserUsername("john11")).thenReturn(
                Optional.of(
                        new UserOrganization(new User("John", "Williams", "john11"),
                                             new Organization("Amazon")
                        )
                )
        );
        Assertions.assertThat(testSubject.userHasJob(1L)).isEqualTo(true);
        Mockito.verify(userRepository).findById(1L);
        Mockito.verify(userOrganizationRepository).findByUserUsername("john11");
        Mockito.verifyNoMoreInteractions(userRepository, userOrganizationRepository, organizationService);
    }

    @Test
    public void testGetAllByOrganizationId() {
        Mockito.when(userOrganizationRepository.findAllByOrganizationId(1L))
                .thenReturn(List.of(
                        new UserOrganization(new User("John", "Williams", "john11"),
                                            new Organization("Amazon"))
                        )
                );
        Assertions.assertThat(testSubject.getAllByOrganizationId(1L)).isEqualTo(
                List.of(new User("John", "Williams", "john11"))
        );
        Mockito.verify(userOrganizationRepository).findAllByOrganizationId(1L);
        Mockito.verifyNoMoreInteractions(userRepository, userOrganizationRepository, organizationService);
    }
}