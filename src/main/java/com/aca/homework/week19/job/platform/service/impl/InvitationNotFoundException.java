package com.aca.homework.week19.job.platform.service.impl;

public class InvitationNotFoundException extends RuntimeException {
    public InvitationNotFoundException(Long invitationId) {
        super(String.format("Invitation with id (%d) not found", invitationId));
    }

    public InvitationNotFoundException(Long userId, Long organizationId) {
        super(String.format("Invitation to a user with id (%d) from organization with id (%d) not found", userId, organizationId));
    }
}
