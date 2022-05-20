package com.aca.homework.week16.organization;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(Long id) {
        super(String.format("Organization with id %d not found.", id));
    }
}
