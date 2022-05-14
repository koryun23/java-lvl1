package com.aca.homework.week19.job.platform.service.core;

import java.util.Objects;

public class OpenToWorkRequestDto {

    private String firstName;
    private String secondName;
    private Long organizationId;

    public OpenToWorkRequestDto(String firstName, String secondName, Long organizationId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.organizationId = organizationId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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
