package com.aca.homework.week19.job.platform.facade.invitation;

import com.aca.homework.week19.job.platform.entity.InvitationStatusType;
import com.aca.homework.week19.job.platform.facade.organization.OrganizationDetailsDto;
import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

public class InvitationDetailsDto {
    private InvitationStatusType status;
    private UserDetailsDto userDto;
    private String organizationName;

    private List<String> errors;

    public InvitationDetailsDto(InvitationStatusType status, UserDetailsDto userDto, String organizationName) {
        Assert.notNull(status, "status should not be null");
        Assert.notNull(userDto, "user details dto object should not be null");
        Assert.notNull(organizationName, "organization name should not be null");
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

    public UserDetailsDto getUserDto() {
        return userDto;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public List<String> getErrors() {
        return errors;
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
