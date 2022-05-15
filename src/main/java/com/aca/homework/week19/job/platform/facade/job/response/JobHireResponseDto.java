package com.aca.homework.week19.job.platform.facade.job.response;

import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public class JobHireResponseDto {

    private Long userId;
    private Long organizationId;
    private List<String> errors;

    public JobHireResponseDto(Long userId, Long organizationId) {
        Assert.notNull(userId, "user id should not be null");
        Assert.notNull(organizationId, "organization id should not be null");
        this.userId = userId;
        this.organizationId = organizationId;
    }

    public JobHireResponseDto(List<String> errors) {
        this.errors = errors;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    @Override
    public String toString() {
        return "JobHireResponseDto{" +
                "userId=" + userId +
                ", organizationId=" + organizationId +
                ", errors=" + errors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobHireResponseDto that = (JobHireResponseDto) o;
        return Objects.equals(userId, that.userId) && Objects.equals(organizationId, that.organizationId) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, organizationId, errors);
    }
}
