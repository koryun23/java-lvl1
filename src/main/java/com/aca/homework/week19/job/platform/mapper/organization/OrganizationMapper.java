package com.aca.homework.week19.job.platform.mapper.organization;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.mapper.Mapper;
import com.aca.homework.week19.job.platform.mapper.user.UserMapper;

import java.util.List;

public interface OrganizationMapper extends Mapper {
    OrganizationDetailsDto map(Organization organization, List<User> allUsers, UserMapper userMapper);
}
