package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.organization.request.OrganizationRegistrationRequestDto;
import com.aca.homework.week19.job.platform.service.core.OrganizationCreationParams;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import com.aca.homework.week19.job.platform.service.core.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrganizationFacadeImplTest {
    private OrganizationFacade organizationFacade;

    @Mock
    private OrganizationService organizationService;

    @Mock
    private UserService userService;

    @BeforeEach
    public void init() {
        organizationFacade = new OrganizationFacadeImpl(organizationService, userService);
    }

    @Test
    public void testRegister() {
        Mockito.when(organizationService.create(new OrganizationCreationParams("Amazon"))).thenReturn(
                new Organization("Amazon")
        );
        OrganizationDetailsDto response = organizationFacade.register(new OrganizationRegistrationRequestDto("Amazon"));
        Assertions.assertThat(response.getName()).isEqualTo("Amazon");
        Assertions.assertThat(response.getEmployees()).isEmpty();
        Mockito.verify(organizationService).create(new OrganizationCreationParams("Amazon"));
        Mockito.verifyNoMoreInteractions(userService, organizationService);
    }

    @Test
    public void testGetOrganizationDetailsWhenOrganizationNotFound() {
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.empty());
        OrganizationDetailsDto organizationDetails = organizationFacade.getOrganizationDetails(1L);
        List<String> errors = organizationDetails.getErrors();
        Assertions.assertThat(errors).isNotEmpty();
        Assertions.assertThat(errors.get(0)).isEqualTo("organization with id(1) not found");
        Mockito.verify(organizationService).findById(1L);
        Mockito.verifyNoMoreInteractions(userService, organizationService);
    }

    @Test
    public void testGetOrganizationDetailsWhenOrganizationExists() {
        Mockito.when(organizationService.findById(1L)).thenReturn(Optional.of(
                new Organization("Amazon")
        ));
        Mockito.when(userService.getAllByOrganizationId(1L)).thenReturn(Collections.emptyList());
        OrganizationDetailsDto organizationDetails = organizationFacade.getOrganizationDetails(1L);
        Assertions.assertThat(organizationDetails.getErrors()).isNull();
        Assertions.assertThat(organizationDetails.getName()).isEqualTo("Amazon");
        Assertions.assertThat(organizationDetails.getEmployees()).isEmpty();
        Mockito.verify(organizationService).findById(1L);
        Mockito.verify(userService).getAllByOrganizationId(1L);
        Mockito.verifyNoMoreInteractions(organizationService, userService);
    }
}