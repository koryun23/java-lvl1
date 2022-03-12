package com.aca.homework.week8.car.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class CarRepositoryTest {
    CarRepository testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new CarRepository();
    }

    @Test
    public void testSave() {
        testSubject.save(new Car("abcd1234", 2007, 3));
        Assertions.assertEquals(1, testSubject.getTotalCount());
    }

    @Test
    public void testSaveSameCar2Times() {
        testSubject.save(new Car("abcd1234", 2007, 3));
        testSubject.save(new Car("abcd1234", 2007, 3));
        Assertions.assertEquals(1, testSubject.getTotalCount());
    }

    @Test
    public void testSave2DifferentCars() {
        testSubject.save(new Car("abcd1234", 2008, 1));
        testSubject.save(new Car("1234abcd", 2007, 3));
        Assertions.assertEquals(2, testSubject.getTotalCount());
    }

    @Test
    public void testSave2DifferentCars2Times() {
        testSubject.save(new Car("abcd1234", 2008, 1));
        testSubject.save(new Car("1234abcd", 2007, 3));
        testSubject.save(new Car("abcd1234", 2008, 1));
        testSubject.save(new Car("1234abcd", 2007, 3));
        Assertions.assertEquals(2, testSubject.getTotalCount());
    }

    @Test
    public void findByVinWhenTotalCountIs0() {
        Car car = testSubject.findByVin("aw57q");
        Assertions.assertNull(car);
    }

    @Test
    public void findByVinWhenCarExists() {
        testSubject.save(new Car("abcd1234", 2008, 1));
        Assertions.assertEquals(new Car("abcd1234", 2008, 1), testSubject.findByVin("abcd1234"));
    }

    @Test
    public void testGetTotalCountWhenThereIsNoSavedCar() {
        Assertions.assertEquals(0, testSubject.getTotalCount());
    }

}