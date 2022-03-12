package com.aca.homework.week8.car.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

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

    @Test
    public void testConstructorNegativeYear(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Car("1234abcd", -1, 1);
            }
        });
    }

    @Test
    public void testConstructorNonValidOwnersCount(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Car("1234abcd", 2020, -1);
            }
        });
    }

    @Test
    public void testSetWhenYearIsNegative(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Car("1234abcd", 2020, 3).setYear(-3);
            }
        });
    }

    @Test
    public void testSetWhenOwnersCountIsNonValid(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new Car("1234abcd", 2020, 3).setOwnersCount(-1);
            }
        });
    }
}