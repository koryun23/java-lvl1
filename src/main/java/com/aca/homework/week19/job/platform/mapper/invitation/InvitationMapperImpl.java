package com.aca.homework.week19.job.platform.mapper.invitation;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.facade.invitation.InvitationDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import org.springframework.stereotype.Component;

@Component
public class InvitationMapperImpl implements InvitationMapper {

    @Override
    public InvitationDetailsDto map(Invitation invitation, UserDetailsDto userDetailsDto, String organizationName) {
        return new InvitationDetailsDto(
                invitation.getStatus(),
                userDetailsDto,
                organizationName
        );
    }
}
