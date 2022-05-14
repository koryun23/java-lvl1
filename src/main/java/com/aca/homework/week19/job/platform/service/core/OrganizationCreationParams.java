package com.aca.homework.week19.job.platform.service.core;

import java.util.Objects;

public class OrganizationCreationParams {
    private String name;

    public OrganizationCreationParams(String name) {
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
        OrganizationCreationParams that = (OrganizationCreationParams) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "OrganizationCreationParams{" +
                "name='" + name + '\'' +
                '}';
    }
}
