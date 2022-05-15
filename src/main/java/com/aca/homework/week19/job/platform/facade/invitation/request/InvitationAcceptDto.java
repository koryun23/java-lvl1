package com.aca.homework.week19.job.platform.facade.invitation.request;

import org.springframework.util.Assert;

import java.util.Objects;

public class InvitationAcceptDto {

    private final Long invitationId;
    private final Long userId;

    public InvitationAcceptDto(Long invitationId, Long userId) {
        Assert.notNull(invitationId, "invitation id should not be null");
        Assert.notNull(userId, "user id should not be null");
        this.invitationId = invitationId;
        this.userId = userId;
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvitationAcceptDto that = (InvitationAcceptDto) o;
        return Objects.equals(invitationId, that.invitationId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitationId, userId);
    }

    @Override
    public String toString() {
        return "InvitationAcceptDto{" +
                "invitationId=" + invitationId +
                ", userId=" + userId +
                '}';
    }
}
