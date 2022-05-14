package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;

import java.util.List;
import java.util.Objects;

public class InvitationDetailsDto {
    private InvitationStatusType status;
    private UserDetailsDto userDto;
    private String organizationName;

    private List<String> errors;

    public InvitationDetailsDto(InvitationStatusType status, UserDetailsDto userDto, String organizationName) {
        this.status = status;
        this.userDto = userDto;
        this.organizationName = organizationName;
    }

    public InvitationDetailsDto(List<String> errors) {
        this.errors = errors;
    }

    public InvitationStatusType getStatus() {
        return status;
    }

    public void setStatus(InvitationStatusType status) {
        this.status = status;
    }

    public UserDetailsDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDetailsDto userDto) {
        this.userDto = userDto;
    }

    public String getOrganizationDto() {
        return organizationName;
    }

    public void setOrganizationDto(String organizationDto) {
        this.organizationName = organizationName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        return "InvitationDetailsDto{" +
                "status=" + status +
                ", userDto=" + userDto +
                ", organizationName='" + organizationName + '\'' +
                ", errors=" + errors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvitationDetailsDto that = (InvitationDetailsDto) o;
        return status == that.status && Objects.equals(userDto, that.userDto) && Objects.equals(organizationName, that.organizationName) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, userDto, organizationName, errors);
    }
}
