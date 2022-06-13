package com.aca.homework.week19.job.platform.service.impl;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.mapper.user.UserMapper;
import com.aca.homework.week19.job.platform.repository.OrganizationRepository;
import com.aca.homework.week19.job.platform.service.core.OrganizationService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrganizationServiceImplTest {

    private OrganizationService testSubject;

    @Mock
    private OrganizationRepository organizationRepository;

    @Mock
    private UserMapper userMapper;

    @BeforeEach
    public void init() {
        testSubject = new OrganizationServiceImpl(organizationRepository, userMapper);
    }

    @Test
    public void testGetByIdWhenOrganizationDoesNotExist() {
        Mockito.when(organizationRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> testSubject.getById(1L)).isExactlyInstanceOf(OrganizationNotFoundException.class);
        Mockito.verify(organizationRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(organizationRepository, userMapper);
    }

    @Test
    public void testFindByIdWhenOrganizationDoesNotExist() {
        Mockito.when(organizationRepository.findById(1L)).thenReturn(Optional.empty());
        Assertions.assertThat(testSubject.findById(1L)).isEqualTo(Optional.empty());
        Mockito.verify(organizationRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(organizationRepository, userMapper);
    }

    @Test
    public void testGetByIdWhenOrganizationExists() {
        Mockito.when(organizationRepository.findById(1L)).thenReturn(Optional.of(new Organization("Amazon")));
        Assertions.assertThat(testSubject.getById(1L)).isEqualTo(new Organization("Amazon"));
        Mockito.verify(organizationRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(organizationRepository, userMapper);
    }

    @Test
    public void testFindByIdWhenOrganizationExists() {
        Mockito.when(organizationRepository.findById(1L)).thenReturn(Optional.of(new Organization("Amazon")));
        Assertions.assertThat(testSubject.findById(1L)).isEqualTo(Optional.of(new Organization("Amazon")));
        Mockito.verify(organizationRepository).findById(1L);
        Mockito.verifyNoMoreInteractions(organizationRepository, userMapper);
    }

    @Test
    public void testGetByNameWhenOrganizationDoesNotExist() {
        Mockito.when(organizationRepository.findByName("Amazon")).thenReturn(Optional.empty());
        Assertions.assertThatThrownBy(() -> testSubject.getByName("Amazon")).isExactlyInstanceOf(OrganizationNotFoundException.class);
        Mockito.verify(organizationRepository).findByName("Amazon");
        Mockito.verifyNoMoreInteractions(organizationRepository, userMapper);
    }

    @Test
    public void testGetByNameWhenOrganizationExists() {
        Mockito.when(organizationRepository.findByName("Amazon")).thenReturn(Optional.of(new Organization("Amazon")));
        Assertions.assertThat(testSubject.getByName("Amazon")).isEqualTo(new Organization("Amazon"));
        Mockito.verify(organizationRepository).findByName("Amazon");
        Mockito.verifyNoMoreInteractions(organizationRepository, userMapper);
    }

}
