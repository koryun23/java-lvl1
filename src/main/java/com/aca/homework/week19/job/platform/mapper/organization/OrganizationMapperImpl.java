package com.aca.homework.week19.job.platform.mapper.organization;

import com.aca.homework.week19.job.platform.entity.Organization;
import com.aca.homework.week19.job.platform.entity.User;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import com.aca.homework.week19.job.platform.mapper.user.UserMapper;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class OrganizationMapperImpl implements OrganizationMapper {

    @Override
    public OrganizationDetailsDto map(Organization organization, List<User> allUsers, UserMapper userMapper) {
        String organizationName = organization.getName();
        List<UserDetailsDto> userDetailsDtos = new LinkedList<>();
        for (User user : allUsers) {
            userDetailsDtos.add(userMapper.map(user));
        }
        return new OrganizationDetailsDto(organizationName, userDetailsDtos);
    }
}
