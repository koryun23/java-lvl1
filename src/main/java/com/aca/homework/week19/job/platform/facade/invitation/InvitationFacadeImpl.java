package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationAcceptDto;
import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationRejectDto;
import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationRequestDto;
import com.aca.homework.week19.job.platform.mapper.invitation.InvitationMapper;
import com.aca.homework.week19.job.platform.mapper.organization.OrganizationMapper;
import com.aca.homework.week19.job.platform.mapper.user.UserMapper;
import com.aca.homework.week19.job.platform.service.core.InvitationCreationParams;
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
public class InvitationFacadeImpl implements InvitationFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvitationFacadeImpl.class);
    private final InvitationService invitationService;
    private final UserService userService;
    private final OrganizationService organizationService;
    private final UserMapper userMapper;
    private final OrganizationMapper organizationMapper;
    private final InvitationMapper invitationMapper;

    public InvitationFacadeImpl(InvitationService invitationService,
                                UserService userService,
                                OrganizationService organizationService,
                                UserMapper userMapper,
                                OrganizationMapper organizationMapper,
                                InvitationMapper invitationMapper) {
        this.invitationService = invitationService;
        this.userService = userService;
        this.organizationService = organizationService;
        this.userMapper = userMapper;
        this.organizationMapper = organizationMapper;
        this.invitationMapper = invitationMapper;
    }

    @Override
    public InvitationDetailsDto sendInvitation(InvitationRequestDto dto) {
        Assert.notNull(dto, "invitation request dto should not be null");
        LOGGER.info("sending an invitation according to invitation request dto - {}", dto);
        Optional<User> userOptional = userService.findById(dto.getUserId());
        if(userOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of("could not send an invitation to a non-existing user"));
        }
        Optional<Organization> organizationOptional = organizationService.findById(dto.getOrganizationId());
        if(organizationOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of("could not send an invitation from a non-existing organization"));
        }
        if(userService.userHasJob(dto.getUserId())) {
            return new InvitationDetailsDto(List.of("could not send an invitation to a user who already has a job"));
        }
        Invitation invitation = invitationService.create(
                new InvitationCreationParams(
                        dto.getUserId(),
                        dto.getOrganizationId()
                )
        );
        invitationService.markAs(invitation.getId(), InvitationStatusType.OPEN);
        InvitationDetailsDto invitationDetailsDto = invitationMapper.map(
                invitation,
                userMapper.map(userService.getById(dto.getUserId())),
                organizationOptional.get().getName()
        );
        LOGGER.info("successfully sent an invitation according to invitation request dto - {}, invitation details - {}", dto, invitationDetailsDto);
        return invitationDetailsDto;
    }

    @Override
    public InvitationDetailsDto acceptInvitation(InvitationAcceptDto dto) {
        Assert.notNull(dto, "invitation acceptance dto should not be null");
        LOGGER.info("accepting an invitation according to invitation acceptance dto - {}", dto);
        Optional<User> userOptional = userService.findById(dto.getUserId());
        if(userOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of("non-existing user cannot accept job invitation"));
        }
        Optional<Invitation> invitationOptional = invitationService.findById(dto.getInvitationId());
        if(invitationOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of("a user cannot accept a non-existing job invitation"));
        }
        Invitation invitation = invitationOptional.get();
        invitationService.markAs(invitation.getId(), InvitationStatusType.ACCEPTED);
        Organization organization = invitation.getOrganization();
        InvitationDetailsDto invitationDetailsDto = new InvitationDetailsDto(
                invitation.getStatus(),
                userMapper.map(userOptional.get()),
                organization.getName()
        );
        LOGGER.info("Successfully accepted the invitation, invitation details - {}", invitationDetailsDto);
        return invitationDetailsDto;
    }

    @Override
    public InvitationDetailsDto rejectInvitation(InvitationRejectDto dto) {
        Assert.notNull(dto, "invitation rejection dto should not be null");
        LOGGER.info("rejecting an invitation according to invitation rejection dto - {}", dto);
        Optional<User> userOptional = userService.findById(dto.getUserId());
        if(userOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of("non-existing user cannot reject job invitation"));
        }
        Optional<Invitation> invitationOptional = invitationService.findById(dto.getInvitationId());
        if(invitationOptional.isEmpty()) {
            return new InvitationDetailsDto(List.of("user cannot reject a non-existing job invitation"));
        }
        Invitation invitation = invitationOptional.get();
        invitationService.markAs(invitation.getId(), InvitationStatusType.REJECTED);
        Organization organization = invitation.getOrganization();
        InvitationDetailsDto invitationDetailsDto = new InvitationDetailsDto(
                invitation.getStatus(),
                userMapper.map(userOptional.get()),
                organization.getName()
        );
        LOGGER.info("successfully rejected an invitation, invitation details - {}", invitationDetailsDto);
        return null;
    }
}
