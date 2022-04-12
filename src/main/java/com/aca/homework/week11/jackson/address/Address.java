package com.aca.homework.week11.jackson.address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("jsonFieldCountry")
    private String country;

    @JsonProperty("jsonFieldCity")
    private String city;

    @JsonProperty("jsonFieldStreet")
    private String street;
}
