package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.invitation.InvitationDetailsDto;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.mapper.user.UserMapper;
import com.aca.homework.week19.job.platform.repository.InvitationRepository;
import com.aca.homework.week19.job.platform.service.core.InvitationCreationParams;
import com.aca.homework.week19.job.platform.service.core.InvitationService;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class InvitationServiceImpl implements InvitationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvitationServiceImpl.class);
    private final InvitationRepository invitationRepository;
    private final UserService userService;
    private final OrganizationService organizationService;
    private final UserMapper userMapper;

    public InvitationServiceImpl(InvitationRepository invitationRepository, UserService userService, OrganizationService organizationService, UserMapper userMapper) {
        this.invitationRepository = invitationRepository;
        this.userService = userService;
        this.organizationService = organizationService;
        this.userMapper = userMapper;
    }


    @Override
    public Invitation create(InvitationCreationParams params) {
        Assert.notNull(params, "invitation creation params should not be null");
        LOGGER.info("saving a new invitation according to params - {}", params);
        Invitation invitation = invitationRepository.save(new Invitation(
                userService.getById(params.getUserId()),
                organizationService.getById(params.getOrganizationId()),
                InvitationStatusType.OPEN
        ));
        LOGGER.info("successfully saved a new invitation - {}", invitation);
        return invitation;
    }

    @Override
    public InvitationDetailsDto markAs(Long invitationId, InvitationStatusType status) {
        Assert.notNull(invitationId, "invitation id should not be null");
        Assert.notNull(status, "invitation status type should not be null");
        LOGGER.info("marking an invitation with id ({}) as {}", invitationId, status);
        Invitation invitation = invitationRepository.findById(invitationId).orElseThrow(() -> new InvitationNotFoundException(invitationId));
        invitation.setStatus(status);
        invitationRepository.save(invitation);
        Organization organization = invitation.getOrganization();
        List<User> users = userService.getAllByOrganizationId(organization.getId());
        List<UserDetailsDto> employees = new LinkedList<>();
        for (User user : users) {
            employees.add(userMapper.map(user));
        }
        User user = invitation.getUser();
        UserDetailsDto userDto = userMapper.map(user);
        OrganizationDetailsDto organizationDto = new OrganizationDetailsDto(organization.getName(), employees);
        InvitationDetailsDto invitationDetailsDto = new InvitationDetailsDto(status, userDto, organization.getName());
        LOGGER.info("successfully marked invitation with id ({}) as {}, invitation details dto - {}", invitationId, status, invitationDetailsDto);
        return invitationDetailsDto;
    }

    @Override
    public Invitation getByUserIdAndOrganizationId(Long userId, Long organizationId) {
        Assert.notNull(userId, "user id should not be null");
        Assert.notNull(organizationId, "organization id should not be null");
        LOGGER.info("retrieving an invitation to a user with id ({}) from organization with id ({})", userId, organizationId);
        Invitation invitation = invitationRepository.findByUserIdAndOrganizationId(userId, organizationId)
                .orElseThrow(() -> new InvitationNotFoundException(userId, organizationId));
        LOGGER.info("successfully retrieved invitation - {}", invitation);
        return invitation;
    }

    @Override
    public Invitation getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("retrieving an invitation with id = {}", id);
        Invitation invitation = invitationRepository.findById(id).orElseThrow(() -> new InvitationNotFoundException(id));
        LOGGER.info("successfully retrieved an invitation - {}", invitation);
        return invitation;
    }

    @Override
    public Optional<Invitation> findById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("retrieving an optional of an invitation with id = {}", id);
        Optional<Invitation> invitationOptional = invitationRepository.findById(id);
        LOGGER.info("successfully retrieved an optional - {}", invitationOptional);
        return invitationOptional;
    }

    @Override
    public Optional<Invitation> findByUserIdAndOrganizationId(Long userId, Long organizationId) {
        Assert.notNull(userId, "user id should not be null");
        Assert.notNull(organizationId, "organization id should not be null");
        LOGGER.info("retrieving an optional of an invitation from organization with id ({}) to user with id ({})", organizationId, userId);
        Optional<Invitation> invitationOptional = invitationRepository.findByUserIdAndOrganizationId(userId, organizationId);
        LOGGER.info("successfully retrieved an optional of an invitation - {}", invitationOptional);
        return invitationOptional;
    }
}
