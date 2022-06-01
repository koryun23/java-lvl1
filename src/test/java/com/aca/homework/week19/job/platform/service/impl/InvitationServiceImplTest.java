package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.mapper.user.UserMapper;
import com.aca.homework.week19.job.platform.repository.InvitationRepository;
import com.aca.homework.week19.job.platform.service.core.InvitationService;
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

@ExtendWith(MockitoExtension.class)
class InvitationServiceImplTest {

    private InvitationService testSubject;

    @Mock
    private InvitationRepository invitationRepository;

    @Mock
    private UserService userService;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        testSubject = new InvitationServiceImpl(invitationRepository, userService, organizationService, userMapper);
    }

    @Test
    public void testGetByIdWhenInvitationDoesNotExist() {
        Mockito.when(invitationRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> testSubject.getById(1L)).isExactlyInstanceOf(InvitationNotFoundException.class);
        Mockito.verify(invitationRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(invitationRepository, userService, organizationService, userMapper);
    }

    @Test
    public void testGetByIdWhenInvitationExists() {
        Mockito.when(invitationRepository.findById(1L)).thenReturn(Optional.of(new Invitation(
                new User("John", "Williams", "john11"),
                new Organization("Amazon"),
                InvitationStatusType.OPEN
        )));
        Assertions.assertThat(testSubject.getById(1L)).isEqualTo(new Invitation(
                new User("John", "Williams", "john11"),
                new Organization("Amazon"),
                InvitationStatusType.OPEN
        ));
        Mockito.verify(invitationRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(invitationRepository, userService, organizationService, userMapper);
    }

    @Test
    public void testFindByIdWhenInvitationDoesNotExist() {
        Mockito.when(invitationRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.findById(1L)).isEqualTo(Optional.empty());
        Mockito.verify(invitationRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(invitationRepository, userService, organizationService, userMapper);
    }

    @Test
    public void testFindByIdWhenInvitationExists() {
        Mockito.when(invitationRepository.findById(1L)).thenReturn(Optional.of(new Invitation(
                new User("John", "Williams", "john11"),
                new Organization("Amazon"),
                InvitationStatusType.OPEN
        )));
        Assertions.assertThat(testSubject.findById(1L)).isEqualTo(Optional.of(new Invitation(
                new User("John", "Williams", "john11"),
                new Organization("Amazon"),
                InvitationStatusType.OPEN
        )));
        Mockito.verify(invitationRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(invitationRepository, userService, organizationService, userMapper);
    }

    @Test
    public void testFindByUserIdAndOrganizationIdWhenInvitationDoesNotExist() {
        Mockito.when(invitationRepository.findByUserIdAndOrganizationId(1L, 1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.findByUserIdAndOrganizationId(1L, 1L)).isEqualTo(Optional.empty());
        Mockito.verify(invitationRepository).findByUserIdAndOrganizationId(1L, 1L);
        Mockito.verifyNoMoreInteractions(invitationRepository, userService, organizationService, userMapper);
    }

    @Test
    public void testFindByUserIdAndOrganizationIdWhenInvitationExists() {
        Mockito.when(invitationRepository.findByUserIdAndOrganizationId(1L, 1L))
                .thenReturn(Optional.of(
                        new Invitation(
                                new User("John", "Williams", "john11"),
                                new Organization("Amazon"),
                                InvitationStatusType.OPEN
                        )
                ));
        Assertions.assertThat(testSubject.findByUserIdAndOrganizationId(1L, 1L)).isEqualTo(
                Optional.of(
                        new Invitation(
                                new User("John", "Williams", "john11"),
                                new Organization("Amazon"),
                                InvitationStatusType.OPEN
                        )
                )
        );
        Mockito.verify(invitationRepository).findByUserIdAndOrganizationId(1L, 1L);
        Mockito.verifyNoMoreInteractions(invitationRepository, userService, organizationService, userMapper);
    }

    @Test
    public void testGetByUserIdAndOrganizationIdWhenInvitationDoesNotExist() {
        Mockito.when(invitationRepository.findByUserIdAndOrganizationId(1L, 1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> testSubject.getByUserIdAndOrganizationId(1L, 1L))
                .isExactlyInstanceOf(InvitationNotFoundException.class);
        Mockito.verify(invitationRepository).findByUserIdAndOrganizationId(1L, 1L);
        Mockito.verifyNoMoreInteractions(invitationRepository, userService, organizationService, userMapper);
    }

    @Test
    public void testGetByUserIdAndOrganizationIdWhenInvitationExists() {
        Mockito.when(invitationRepository.findByUserIdAndOrganizationId(1L, 1L))
                .thenReturn(Optional.of(
                        new Invitation(
                                new User("John", "Williams", "john11"),
                                new Organization("Amazon"),
                                InvitationStatusType.OPEN
                        )
                ));
        Assertions.assertThat(testSubject.getByUserIdAndOrganizationId(1L, 1L)).isEqualTo(
                new Invitation(
                        new User("John", "Williams", "john11"),
                        new Organization("Amazon"),
                        InvitationStatusType.OPEN
                )
        );
        Mockito.verify(invitationRepository).findByUserIdAndOrganizationId(1L, 1L);
        Mockito.verifyNoMoreInteractions(invitationRepository, userService, organizationService, userMapper);
    }

    @Test
    public void testMarkAs() { // TODO: FIX THIS TEST
        Mockito.when(invitationRepository.findById(1L)).thenReturn(Optional.of(new Invitation(
                new User("John", "Williams", "john11"),
                new Organization("Amazon"),
                InvitationStatusType.OPEN
        )));
        Mockito.when(userService.getAllByOrganizationId(1L)).thenReturn(List.of(new User("John", "Williams", "john11")));
        Mockito.when(userMapper.map(new User("John", "Williams", "john11")))
                .thenReturn(new UserDetailsDto("John", "Williams", "john11"));
        testSubject.markAs(1L, InvitationStatusType.ACCEPTED);
        Assertions.assertThat(testSubject.getById(1L).getStatus()).isEqualTo(InvitationStatusType.ACCEPTED);
        Mockito.verify(invitationRepository).findById(1L);
        Mockito.verify(userService).getAllByOrganizationId(1L);
        Mockito.verify(userMapper).map(new User("John", "Williams", "john11"));
        Mockito.verifyNoMoreInteractions(invitationRepository, userService, organizationService, userMapper);
    }

}