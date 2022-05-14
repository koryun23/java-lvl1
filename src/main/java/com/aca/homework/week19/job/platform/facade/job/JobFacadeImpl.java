package com.aca.homework.week19.job.platform.facade.job;

import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.job.request.JobHireRequestDto;
import com.aca.homework.week19.job.platform.facade.job.response.JobHireResponseDto;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.service.core.InvitationService;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

@Component
public class JobFacadeImpl implements JobFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobFacadeImpl.class);
    private final UserService userService;
    private final OrganizationService organizationService;
    private final InvitationService invitationService;

    public JobFacadeImpl(UserService userService, OrganizationService organizationService, InvitationService invitationService) {
        this.userService = userService;
        this.organizationService = organizationService;
        this.invitationService = invitationService;
    }

    @Override
    public JobHireResponseDto hire(JobHireRequestDto dto) {
        Assert.notNull(dto, "job hire request dto should not be null");
        LOGGER.info("hiring a user according to job hire request dto - {}", dto);
        if(!isValidJobHireRequestDto(dto)) {
            return new JobHireResponseDto(List.of(String.format("user with id(%d) did not accept invitation from organization with id(%d)", dto.getUserId(), dto.getOrganizationId())));
        }
        invitationService.getByUserIdAndOrganizationId(dto.getUserId(), dto.getOrganizationId()).getStatus();
        User user = userService.registerUserAtOrganization(dto.getUserId(), dto.getOrganizationId());
        JobHireResponseDto responseDto = new JobHireResponseDto(
                dto.getUserId(),
                dto.getOrganizationId()
        );
        LOGGER.info("Successfully registered user {} at organization {}.", user, organizationService.getById(dto.getOrganizationId()));
        return responseDto;
    }

    private boolean isValidJobHireRequestDto(JobHireRequestDto dto) {
        return invitationService.getByUserIdAndOrganizationId(
                dto.getUserId(),
                dto.getOrganizationId()
        ).getStatus() == InvitationStatusType.ACCEPTED;
    }
}
