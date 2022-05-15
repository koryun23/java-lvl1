package com.aca.homework.week19.job.platform.service.core;

import org.springframework.util.Assert;

import java.util.Objects;

public class OrganizationCreationParams {
    private final String name;

    public OrganizationCreationParams(String name) {
        Assert.notNull(name, "organization name should not be null");
        this.name = name;
    }

    public String getName() {
        return name;
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
