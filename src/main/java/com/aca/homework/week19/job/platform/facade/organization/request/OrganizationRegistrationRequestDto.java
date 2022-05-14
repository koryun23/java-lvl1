package com.aca.homework.week19.job.platform.facade.organization.request;

import java.util.Objects;

public class OrganizationRegistrationRequestDto {
    private String name;

    public OrganizationRegistrationRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationRegistrationRequestDto that = (OrganizationRegistrationRequestDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "OrganizationRegistrationRequestDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
