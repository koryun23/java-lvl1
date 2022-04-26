package com.aca.homework.week16.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.Objects;

public class OrganizationCreateParams {

    private final String name;
    private final String fullAddress;
    Logger LOGGER = LoggerFactory.getLogger(OrganizationCreateParams.class);

    public OrganizationCreateParams(String name, String fullAddress) {
        LOGGER.info("Creating params object");
        Assert.notNull(name, "name should not be null");
        Assert.notNull(fullAddress, "full address should not be null");
        this.name = name;
        this.fullAddress = fullAddress;
        LOGGER.info("Successfully created params object - {}", this);
    }

    public String getName() {
        return name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    @Override
    public String toString() {
        return "OrganizationCreateParams{" +
                "name='" + name + '\'' +
                ", fullAddress='" + fullAddress + '\'' +
                '}';
    }
}
