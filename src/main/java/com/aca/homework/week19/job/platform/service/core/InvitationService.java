package com.aca.homework.week19.job.platform.service.core;

import com.aca.homework.week19.job.platform.entity.Invitation;
import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import com.aca.homework.week19.job.platform.facade.invitation.InvitationDetailsDto;

import java.util.Optional;

public interface InvitationService {

    Invitation create(InvitationCreationParams params);

    InvitationDetailsDto markAs(Long invitationId, InvitationStatusType status);

    Invitation getByUserIdAndOrganizationId(Long userId, Long organizationId);

    Invitation getById(Long id);

    Optional<Invitation> findById(Long id);
}
