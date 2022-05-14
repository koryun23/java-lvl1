package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationAcceptDto;
import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationRejectDto;
import com.aca.homework.week19.job.platform.facade.invitation.request.InvitationRequestDto;

public interface InvitationFacade {
    InvitationDetailsDto sendInvitation(InvitationRequestDto dto);

    InvitationDetailsDto acceptInvitation(InvitationAcceptDto dto);

    InvitationDetailsDto rejectInvitation(InvitationRejectDto dto);
}
