package com.aca.homework.week14.parallel.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
    @JsonProperty("name")
    private final String name;

    @JsonProperty("latitude")
    private final String latitude;

    @JsonProperty("longitude")
    private final String longitude;

    public City(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
