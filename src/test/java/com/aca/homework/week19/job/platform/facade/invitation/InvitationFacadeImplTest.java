package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationRequestDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.mapper.invitation.InvitationMapper;
import com.aca.homework.week19.job.platform.mapper.invitation.InvitationMapperImpl;
import com.aca.homework.week19.job.platform.mapper.organization.OrganizationMapper;
import com.aca.homework.week19.job.platform.mapper.organization.OrganizationMapperImpl;
import com.aca.homework.week19.job.platform.mapper.user.UserMapper;
import com.aca.homework.week19.job.platform.mapper.user.UserMapperImpl;
import com.aca.homework.week19.job.platform.service.core.InvitationCreationParams;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InvitationFacadeImplTest {

    private InvitationFacade testSubject;

    @Mock
    private UserService userService;

    @Mock
    private InvitationService invitationService;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private OrganizationMapper organizationMapper;

    @Mock
    private InvitationMapper invitationMapper;

    @BeforeEach
    public void init() {
        testSubject = new InvitationFacadeImpl(
                invitationService,
                userService,
                organizationService,
                userMapper,
                organizationMapper,
                invitationMapper
        );
    }

    @Test
    public void testSendInvitationWhenUserDoesNotExist() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.empty());
        InvitationDetailsDto invitationDetailsDto = testSubject.sendInvitation(
                new InvitationRequestDto(
                        1L, 2L
                )
        );
        List<String> errorList = invitationDetailsDto.getErrors();
        Assertions.assertThat(errorList).isNotEmpty();
        Assertions.assertThat(errorList.get(0)).isEqualTo("could not send an invitation to a non-existing user");
        Mockito.verify(userService).findById(1L);
        Mockito.verifyNoMoreInteractions(userService, invitationService, organizationService);
    }

    @Test
    public void testSendInvitationWhenOrganizationDoesNotExist() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(new User("John", "Jackson", "jj")));
        Mockito.when(organizationService.findById(2L)).thenReturn(Optional.empty());
        InvitationDetailsDto invitationDetailsDto = testSubject.sendInvitation(new InvitationRequestDto(
                1L, 2L
        ));
        List<String> errors = invitationDetailsDto.getErrors();
        Assertions.assertThat(errors).isNotEmpty();
        Assertions.assertThat(errors.get(0)).isEqualTo("could not send an invitation from a non-existing organization");
        Mockito.verify(userService).findById(1L);
        Mockito.verify(organizationService).findById(2L);
        Mockito.verifyNoMoreInteractions(userService, organizationService, invitationService);
    }

    @Test
    public void testSendInvitationWhenUserIsEmployed() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(new User("John", "Jackson", "jj")));
        Mockito.when(organizationService.findById(2L)).thenReturn(Optional.of(new Organization("Amazon")));
        Mockito.when(userService.userHasJob(1L)).thenReturn(true);
        InvitationDetailsDto invitationDetailsDto = testSubject.sendInvitation(new InvitationRequestDto(1L, 2L));
        List<String> errors = invitationDetailsDto.getErrors();
        Assertions.assertThat(errors).isNotEmpty();
        Assertions.assertThat(errors.get(0)).isEqualTo("could not send an invitation to a user who already has a job");
        Mockito.verify(userService).findById(1L);
        Mockito.verify(organizationService).findById(2L);
        Mockito.verify(userService).userHasJob(1L);
    }

    @Test
    public void sendValidInvitation() {
        User user = new User("John", "Jackson", "jj");
        UserDetailsDto userDetailsDto = new UserDetailsDto("John", "Jackson");
        String organizationName = "Amazon";
        Organization organization = new Organization(organizationName);
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(user));
        Mockito.when(organizationService.findById(2L)).thenReturn(Optional.of(organization));
        Mockito.when(userService.userHasJob(1L)).thenReturn(false);
        Mockito.when(invitationService.create(
                new InvitationCreationParams(
                        1L, 2L
                )
        )).thenReturn(new Invitation(
                user,
                organization,
                InvitationStatusType.OPEN
        ));
        Mockito.when(userMapper.map(user)).thenReturn(userDetailsDto);
        Mockito.when(invitationMapper.map(
                new Invitation(user, organization, InvitationStatusType.OPEN),
                userDetailsDto,
                organizationName
        )).thenReturn(new InvitationDetailsDto(
                InvitationStatusType.OPEN,
                userDetailsDto,
                organizationName
        ));
        InvitationDetailsDto invitationDetailsDto = testSubject.sendInvitation(new InvitationRequestDto(1L, 2L));
        Assertions.assertThat(invitationDetailsDto.getStatus()).isEqualTo(InvitationStatusType.OPEN);
        Assertions.assertThat(invitationDetailsDto.getUserDto()).isEqualTo(userDetailsDto);
        Assertions.assertThat(invitationDetailsDto.getOrganizationName()).isEqualTo(organizationName);
        Mockito.verify(userService).findById(1L);
        Mockito.verify(userService).userHasJob(1L);
        Mockito.verify(organizationService).findById(2L);
        Mockito.verify(invitationService).markAs(null, InvitationStatusType.OPEN);
        Mockito.verifyNoMoreInteractions(
                userService,
                userService,
                organizationService,
                invitationService
        );
    }
}
