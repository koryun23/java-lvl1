package com.aca.homework.week19.job.platform.facade.invitation.request;

import org.springframework.util.Assert;

import java.util.Objects;

public class InvitationRejectDto {

    private final Long userId;
    private final Long invitationId;

    public InvitationRejectDto(Long userId, Long invitationId) {
        Assert.notNull(userId, "user id should not be null");
        Assert.notNull(invitationId, "invitation id should not be null");
        this.userId = userId;
        this.invitationId = invitationId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getInvitationId() {
        return invitationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvitationRejectDto that = (InvitationRejectDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(invitationId, that.invitationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, invitationId);
    }

    @Override
    public String toString() {
        return "InvitationRejectDto{" +
                "userId=" + userId +
                ", invitationId=" + invitationId +
                '}';
    }
}
