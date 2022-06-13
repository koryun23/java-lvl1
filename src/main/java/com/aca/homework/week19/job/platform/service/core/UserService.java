package com.aca.homework.week19.job.platform.service.core;

import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User create(UserCreationParams params);

    Optional<User> findById(Long id);

    User getById(Long id);

    List<User> getAllByOrganizationId(Long organizationId);

    User registerUserAtOrganization(Long userId, Long organizationId);

    User removeUserFromOrganization(Long userId);

    boolean userHasJob(Long userId);
}
