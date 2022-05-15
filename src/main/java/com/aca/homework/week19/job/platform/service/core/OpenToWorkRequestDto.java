package com.aca.homework.week19.job.platform.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public class OpenToWorkRequestDto {

    private final String firstName;
    private final String secondName;
    private final Long organizationId;

    public OpenToWorkRequestDto(String firstName, String secondName, Long organizationId) {
        Assert.notNull(firstName, "first name should not be null");
        Assert.notNull(secondName, "second name should not be null");
        Assert.notNull(organizationId, "organization id should not be null");
        this.firstName = firstName;
        this.secondName = secondName;
        this.organizationId = organizationId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenToWorkRequestDto that = (OpenToWorkRequestDto) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(organizationId, that.organizationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, organizationId);
    }

    @Override
    public String toString() {
        return "OpenToWorkRequestDto{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", organizationId=" + organizationId +
                '}';
    }
}
