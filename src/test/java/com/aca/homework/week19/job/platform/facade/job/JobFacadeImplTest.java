package com.aca.homework.week19.job.platform.facade.job;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.job.request.JobHireRequestDto;
import com.aca.homework.week19.job.platform.facade.job.response.JobHireResponseDto;
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
class JobFacadeImplTest {

    private JobFacade testSubject;

    @Mock
    private UserService userService;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private InvitationService invitationService;

    @BeforeEach
    public void init() {
        testSubject = new JobFacadeImpl(userService, organizationService, invitationService);
    }

    @Test
    public void testHireUserWhenUserDoesNotExist() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.empty());
        JobHireResponseDto hire = testSubject.hire(new JobHireRequestDto(
                1L, 1L
        ));
        List<String> errors = hire.getErrors();
        Assertions.assertThat(errors).isNotEmpty();
        Assertions.assertThat(errors.get(0)).isEqualTo("Organization cannot hire a non-existing user");
        Mockito.verify(userService).findById(1L);
        Mockito.verifyNoMoreInteractions(userService, invitationService, organizationService);
    }

    @Test
    public void testHireUserWhenOrganizationDoesNotExist() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(
                new User("John", "Jackson", "jj")
        ));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.empty());
        JobHireResponseDto hire = testSubject.hire(new JobHireRequestDto(
                1L, 1L
        ));
        List<String> errors = hire.getErrors();
        Assertions.assertThat(errors).isNotEmpty();
        Assertions.assertThat(errors.get(0)).isEqualTo("Non-existing organization cannot hire a user");
        Mockito.verify(userService).findById(1L);
        Mockito.verify(organizationService).findById(1L);
        Mockito.verifyNoMoreInteractions(userService, organizationService, invitationService);
    }

    @Test
    public void testHireUserWhenInvitationDoesNotExist() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(
                new User("John", "Jackson", "jj")
        ));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(
                new Organization("Amazon")
        ));
        Mockito.when(invitationService.findByUserIdAndOrganizationId(1L, 1L)).thenReturn(Optional.empty());
        JobHireResponseDto hire = testSubject.hire(new JobHireRequestDto(1L, 1L));
        List<String> errors = hire.getErrors();
        Assertions.assertThat(errors).isNotEmpty();
        Assertions.assertThat(errors.get(0)).isEqualTo("no invitation was sent to a user with id(1) from organization with id(1)");
        Mockito.verify(userService).findById(1L);
        Mockito.verify(organizationService).findById(1L);
        Mockito.verify(invitationService).findByUserIdAndOrganizationId(1L, 1L);
    }

    @Test
    public void testHireUserWhenInvitationStatusIsNotAccepted() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(
                new User("John", "Jackson", "jj")
        ));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(
                new Organization("Amazon")
        ));
        Mockito.when(invitationService.findByUserIdAndOrganizationId(1L, 1L)).thenReturn(Optional.of(
                new Invitation(
                        new User("John", "Jackson", "jj"),
                        new Organization("Amazon"),
                        InvitationStatusType.OPEN
                )
        ));
        JobHireResponseDto hire = testSubject.hire(new JobHireRequestDto(1L, 1L));
        List<String> errors = hire.getErrors();
        Assertions.assertThat(errors).isNotEmpty();
        Assertions.assertThat(errors.get(0)).isEqualTo("user with id(1) did not accept job invitation from organization with id(1)");
        Mockito.verify(userService).findById(1L);
        Mockito.verify(organizationService).findById(1L);
        Mockito.verify(invitationService).findByUserIdAndOrganizationId(1L, 1L);
        Mockito.verifyNoMoreInteractions(userService, organizationService, invitationService);
    }

    @Test
    public void testHireUserWhenInvitationIsValid() {
        Mockito.when(userService.findById(1L)).thenReturn(Optional.of(
                new User("John", "Jackson", "jj")
        ));
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(
                new Organization("Amazon")
        ));
        Mockito.when(invitationService.findByUserIdAndOrganizationId(1L, 1L)).thenReturn(Optional.of(
                new Invitation(
                        new User("John", "Jackson", "jj"),
                        new Organization("Amazon"),
                        InvitationStatusType.ACCEPTED
                )
        ));
        Mockito.when(userService.registerUserAtOrganization(1L, 1L)).thenReturn(
                new User("John", "Jackson", "jj")
        );
        JobHireResponseDto hire = testSubject.hire(new JobHireRequestDto(1L, 1L));
        Assertions.assertThat(hire.getErrors()).isNull();
        Assertions.assertThat(hire.getUserId()).isEqualTo(1L);
        Assertions.assertThat(hire.getOrganizationId()).isEqualTo(1L);
        Mockito.verify(userService).findById(1L);
        Mockito.verify(organizationService).findById(1L);
        Mockito.verify(invitationService).findByUserIdAndOrganizationId(1L, 1L);
        Mockito.verifyNoMoreInteractions(userService, organizationService, invitationService);
    }
}