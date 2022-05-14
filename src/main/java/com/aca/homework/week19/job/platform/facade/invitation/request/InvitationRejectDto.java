package com.aca.homework.week19.job.platform.facade.invitation.request;

import java.util.Objects;

public class InvitationRejectDto {
    private Long userId;
    private Long invitationId;

    public InvitationRejectDto(Long userId, Long invitationId) {
        this.userId = userId;
        this.invitationId = invitationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Long invitationId) {
        this.invitationId = invitationId;
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
