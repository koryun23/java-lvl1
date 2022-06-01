package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.mapper.user.UserMapper;
import com.aca.homework.week19.job.platform.repository.OrganizationRepository;
import com.aca.homework.week19.job.platform.service.core.OrganizationCreationParams;
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
public class OrganizationServiceImpl implements OrganizationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);
    private final OrganizationRepository organizationRepository;
    private final UserMapper userMapper;

    public OrganizationServiceImpl(OrganizationRepository organizationRepository, UserMapper userMapper) {
        Assert.notNull(organizationRepository, "organization repository should not be null");
        Assert.notNull(userMapper, "user mapper should not be null");
        this.organizationRepository = organizationRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Organization create(OrganizationCreationParams params) {
        Assert.notNull(params, "organization creation params should not be null");
        LOGGER.info("Saving a new organization according to the params - {}", params);
        Organization organization = organizationRepository.save(new Organization(params.getName()));
        LOGGER.info("Successfully saved a new organization - {}", organization);
        return organization;
    }

    @Override
    public Optional<Organization> findById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Retrieving an optional of an organization having id {}", id);
        Optional<Organization> optionalOrganization = organizationRepository.findById(id);
        LOGGER.info("Successfully retrieved an optional - {}", optionalOrganization);
        return optionalOrganization;
    }

    @Override
    public Organization getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Retrieving an organization having id {}", id);
        Organization organization = organizationRepository.findById(id).orElseThrow(() -> new OrganizationNotFoundException(id));
        LOGGER.info("Successfully retrieved an organization - {}", organization);
        return organization;
    }

    @Override
    public Organization getByName(String name) {
        Assert.notNull(name, "organization name should not be null");
        LOGGER.info("Retrieving an organization named '{}'", name);
        Organization organization = organizationRepository.findByName(name).orElseThrow(
                () -> new OrganizationNotFoundException(name)
        );
        LOGGER.info("Successfully retrieved an organization - {}", organization);
        return organization;
    }
}
