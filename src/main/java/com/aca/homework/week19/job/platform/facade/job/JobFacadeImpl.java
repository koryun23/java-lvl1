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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Component
public class JobFacadeImpl implements JobFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobFacadeImpl.class);
    private final UserService userService;
    private final OrganizationService organizationService;
    private final InvitationService invitationService;

    public JobFacadeImpl(UserService userService, OrganizationService organizationService, InvitationService invitationService) {
        Assert.notNull(userService, "user service should not be null");
        Assert.notNull(organizationService, "organization service should not be null");
        Assert.notNull(invitationService, "invitation service should not be null");
        this.userService = userService;
        this.organizationService = organizationService;
        this.invitationService = invitationService;
    }

    @Override
    public JobHireResponseDto hire(JobHireRequestDto dto) {
        Assert.notNull(dto, "job hire request dto should not be null");
        LOGGER.info("Hiring a user according to the job hire request dto - {}", dto);

        Optional<User> userOptional = userService.findById(dto.getUserId());
        if(userOptional.isEmpty()) {
            return new JobHireResponseDto(List.of("Organization cannot hire a non-existing user"));
        }

        Optional<Organization> organizationOptional = organizationService.findById(dto.getOrganizationId());
        if(organizationOptional.isEmpty()) {
            return new JobHireResponseDto(List.of("Non-existing organization cannot hire a user"));
        }

        Optional<Invitation> invitationOptional = invitationService.findByUserIdAndOrganizationId(dto.getUserId(), dto.getOrganizationId());
        if(invitationOptional.isEmpty()) {
            return new JobHireResponseDto(List.of(String.format("no invitation was sent to a user with id(%d) from organization with id(%d)", dto.getUserId(), dto.getOrganizationId())));
        }

        if(invitationOptional.get().getStatus() != InvitationStatusType.ACCEPTED) {
            return new JobHireResponseDto(List.of(String.format("user with id(%d) did not accept job invitation from organization with id(%d)", dto.getUserId(), dto.getOrganizationId())));
        }

        User user = userService.registerUserAtOrganization(dto.getUserId(), dto.getOrganizationId());
        JobHireResponseDto responseDto = new JobHireResponseDto(
                dto.getUserId(),
                dto.getOrganizationId()
        );
        LOGGER.info("Successfully registered user {} at organization {}.", user, organizationOptional.get());
        return responseDto;
    }
}
