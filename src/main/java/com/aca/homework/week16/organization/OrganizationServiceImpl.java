package com.aca.homework.week16.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        LOGGER.info("Creating an OrganizationServiceImpl object");
        this.organizationRepository = organizationRepository;
        LOGGER.info("Successfully created an OrganizationServiceImpl object");
    }

    @Override
    public Organization create(OrganizationCreateParams params) {
        LOGGER.info("Retrieving an organization from the provided params - {}", params);
        Assert.notNull(params, "parameters required for user creation should not be null");
        Organization organization = new Organization(params.getName(), params.getFullAddress());
        LOGGER.info("Successfully retrieved a {} from the provided params - {}", organization, params);
        return organization;
    }

    @Override
    public Organization getById(Long id) {
        Assert.notNull(id, "id should not be null");
        LOGGER.info("Retrieving an organization from the id - {}", id);
        Organization organization = organizationRepository.findById(id).orElseThrow(() -> new OrganizationNotFoundException(id));
        LOGGER.info("Successfully retrieved an {} from the id {}", organization, id);
        return organization;
    }
}
