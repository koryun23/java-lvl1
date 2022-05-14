package com.aca.homework.week19.job.platform.facade.organization;

import com.aca.homework.week19.job.platform.facade.user.UserDetailsDto;

import java.util.List;
import java.util.Objects;

public class OrganizationDetailsDto {

    private String name;
    private List<UserDetailsDto> employees;

    private List<String> errors;

    public OrganizationDetailsDto(String name, List<UserDetailsDto> employees) {
        this.name = name;
        this.employees = employees;
    }

    public OrganizationDetailsDto(List<String> errors) {
        this.errors = errors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserDetailsDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<UserDetailsDto> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "OrganizationDetailsDto{" +
                "name='" + name + '\'' +
                ", employees=" + employees +
                ", errors=" + errors +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationDetailsDto that = (OrganizationDetailsDto) o;
        return Objects.equals(name, that.name) && Objects.equals(employees, that.employees) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employees, errors);
    }
}
