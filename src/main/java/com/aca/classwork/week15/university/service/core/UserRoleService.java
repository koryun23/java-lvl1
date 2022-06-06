package com.aca.classwork.week15.university.service.core;

import com.aca.classwork.week15.university.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    UserRole getById(Long id);

    List<UserRole> getByUsername(String username);
}
