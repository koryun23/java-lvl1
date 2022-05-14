package com.aca.homework.week19.job.platform.service.impl;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(Long id) {
        super(String.format("Organization with id(%d) not found", id));
    }

    public OrganizationNotFoundException(String name) {
        super(String.format("Organization with name (%s) not found", name));
    }
}
