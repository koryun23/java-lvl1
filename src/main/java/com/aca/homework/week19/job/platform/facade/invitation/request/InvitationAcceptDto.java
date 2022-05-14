package com.aca.homework.week19.job.platform.facade.invitation.request;

import java.util.Objects;

public class InvitationAcceptDto {
    private Long invitationId;
    private Long userId;

    public InvitationAcceptDto(Long invitationId, Long userId) {
        this.invitationId = invitationId;
        this.userId = userId;
    }

    public Long getInvitationId() {
        return invitationId;
    }

    public void setInvitationId(Long invitationId) {
        this.invitationId = invitationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
