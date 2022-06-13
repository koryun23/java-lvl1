package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.facade.organization.request.OrganizationRegistrationRequestDto;

public interface OrganizationFacade {

    OrganizationDetailsDto register(OrganizationRegistrationRequestDto dto);

    OrganizationDetailsDto getOrganizationDetails(Long organizationId);
}
