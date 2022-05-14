package com.aca.homework.week19.job.platform.facade.invitation.request;

import java.util.Objects;

public class InvitationRequestDto {
    private Long userId;
    private Long organizationId;

    public InvitationRequestDto(Long userId, Long organizationId) {
        this.userId = userId;
        this.organizationId = organizationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvitationRequestDto that = (InvitationRequestDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId);
    }

    @Override
    public String toString() {
        return "InvitationRequestDto{" +
                "userId=" + userId +
                ", organizationId=" + organizationId +
                '}';
    }
}
