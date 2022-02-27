package com.aca.homework.week8.car.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    public void testWhenReferenceIsSame(){
        Car car = new Car("abcd1234", 2007, 3);
        Assertions.assertEquals(car, car);
    }

    @Test
    public void testWhenCarsHaveSameFieldValues(){
        Car car1 = new Car("abcd1234", 2007, 3);
        Car car2 = new Car("abcd1234", 2007, 3);
        Assertions.assertEquals(car1, car2);
    }

    @Test
    public void testCarEqualsString(){
        Car car = new Car("abcd1234", 2007, 3);
        Assertions.assertNotEquals(car, "");
    }
}