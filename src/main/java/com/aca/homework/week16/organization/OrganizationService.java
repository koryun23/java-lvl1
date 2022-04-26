package com.aca.homework.week16.organization;

public interface OrganizationService {
    Organization create(OrganizationCreateParams params);

    Organization getById(Long id);
}
