package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.organization.request.OrganizationRegistrationRequestDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.service.core.OrganizationCreationParams;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Component
public class OrganizationFacadeImpl implements OrganizationFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationFacadeImpl.class);
    private final OrganizationService organizationService;
    private final UserService userService;

    public OrganizationFacadeImpl(OrganizationService organizationService, UserService userService) {
        Assert.notNull(organizationService, "organization service should not be null");
        Assert.notNull(userService, "user service should not be null");
        this.organizationService = organizationService;
        this.userService = userService;
    }

    @Override
    public OrganizationDetailsDto register(OrganizationRegistrationRequestDto dto) {
        Assert.notNull(dto, "organization registration request dto should not be null");
        LOGGER.info("Registering a new organization according to the organization registration request dto - {}", dto);
        Organization organization = organizationService.create(new OrganizationCreationParams(
                dto.getName()
        ));
        OrganizationDetailsDto organizationDetailsDto = new OrganizationDetailsDto(
                organization.getName(),
                Collections.emptyList()
        );
        LOGGER.info("Successfully registered a new organization - {}, organization details dto - {}", organization, organizationDetailsDto);
        return organizationDetailsDto;
    }

    @Override
    public OrganizationDetailsDto getOrganizationDetails(Long organizationId) {
        Assert.notNull(organizationId, "organization id should not be null");
        LOGGER.info("Retrieving organization details of an organization having id - {}", organizationId);

        Optional<Organization> organizationOptional = organizationService.findById(organizationId);
        if (organizationOptional.isEmpty()) {
            return new OrganizationDetailsDto(List.of(String.format("organization with id(%d) not found", organizationId)));
        }
        Organization organization = organizationOptional.get();

        List<UserDetailsDto> userDetailsDtos = new LinkedList<>();
        List<User> allByOrganizationId = userService.getAllByOrganizationId(organizationId);
        for (User user : allByOrganizationId) {
            userDetailsDtos.add(new UserDetailsDto(user.getFirstName(), user.getSecondName(), user.getUsername()));
        }
        OrganizationDetailsDto organizationDetailsDto = new OrganizationDetailsDto(
                organization.getName(),
                userDetailsDtos
        );
        LOGGER.info("Successfully retrieved organization details dto-s - {}", organizationDetailsDto);
        return organizationDetailsDto;
    }
}
