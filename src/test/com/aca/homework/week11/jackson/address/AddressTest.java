package com.aca.homework.week11.jackson.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

class AddressTest {
    private Address testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new Address();
    }

    @Test
    public void testCountryFieldAnnotation() throws NoSuchFieldException {
        Field countryField = testSubject.getClass().getDeclaredField("country");
        Assertions.assertEquals("JsonProperty", countryField.getDeclaredAnnotation(JsonProperty.class).annotationType().getSimpleName());
        Assertions.assertEquals("jsonFieldCountry", countryField.getDeclaredAnnotation(JsonProperty.class).value());
    }

    @Test
    public void testCityFieldAnnotation() throws NoSuchFieldException {
        Field cityField = testSubject.getClass().getDeclaredField("city");
        Assertions.assertEquals("JsonProperty", cityField.getDeclaredAnnotation(JsonProperty.class).annotationType().getSimpleName());
        Assertions.assertEquals("jsonFieldCity", cityField.getDeclaredAnnotation(JsonProperty.class).value());
    }

    @Test
    public void testStreetFieldAnnotation() throws NoSuchFieldException {
        Field streetField = testSubject.getClass().getDeclaredField("street");
        Assertions.assertEquals("JsonProperty", streetField.getDeclaredAnnotation(JsonProperty.class).annotationType().getSimpleName());
        Assertions.assertEquals("jsonFieldStreet", streetField.getDeclaredAnnotation(JsonProperty.class).value());
    }

}