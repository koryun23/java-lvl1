package com.aca.homework.week19.job.platform.service.core;

import java.util.Objects;

public final class InvitationCreationParams {
    private Long userId;
    private Long organizationId;

    public InvitationCreationParams(Long userId, Long organizationId) {
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
        InvitationCreationParams that = (InvitationCreationParams) o;
        return Objects.equals(userId, that.userId) && Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId);
    }

    @Override
    public String toString() {
        return "InvitationCreationParams{" +
                "userId=" + userId +
                ", organizationId=" + organizationId +
                '}';
    }
}
