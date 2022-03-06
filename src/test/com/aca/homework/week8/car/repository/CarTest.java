package com.aca.homework.week8.car.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    public void testWhenReferenceIsSame() {
        Car car = new Car("abcd1234", 2007, 3);
        Assertions.assertEquals(car, car);
    }

    @Test
    public void testWhenCarsHaveSameFieldValues() {
        Assertions.assertEquals(new Car("abcd1234", 2007, 3), new Car("abcd1234", 2007, 3));
    }

    @Test
    public void testCarEqualsString() {
        Assertions.assertNotEquals(new Car("abcd1234", 2007, 3), "");
    }
}