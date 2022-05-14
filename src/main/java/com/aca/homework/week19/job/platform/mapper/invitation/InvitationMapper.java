package com.aca.homework.week19.job.platform.mapper.invitation;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.facade.invitation.InvitationDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;

public interface InvitationMapper {
    InvitationDetailsDto map(Invitation invitation, UserDetailsDto userDetailsDto, String organizationName);
}
