package com.aca.homework.week19.job.platform.facade.job.request;

import org.springframework.util.Assert;

import java.util.Objects;

public class JobHireRequestDto {
    private final Long userId;
    private final Long organizationId;

    public JobHireRequestDto(Long userId, Long organizationId) {
        Assert.notNull(userId, "user id should not be null");
        Assert.notNull(organizationId, "organization id should not be null");
        this.userId = userId;
        this.organizationId = organizationId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    @Override
    public String toString() {
        return "JobHireRequestDto{" +
                "userId=" + userId +
                ", organizationId=" + organizationId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobHireRequestDto that = (JobHireRequestDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId);
    }
}
