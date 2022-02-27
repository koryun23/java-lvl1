package com.aca.homework.week8.car.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class CarRepositoryTest {
    CarRepository testSubject;

    @BeforeEach
    public void setUp(){
        testSubject = new CarRepository();
    }

    @Test
    public void testSave(){
        Car car = new Car("abcd1234", 2007, 3);
        testSubject.save(car);
        Assertions.assertEquals(1, testSubject.getTotalCount());
    }

    @Test
    public void testSaveSameCar2Times(){
        Car car = new Car("abcd1234", 2007, 3);
        testSubject.save(car);
        testSubject.save(car);
        Assertions.assertEquals(1, testSubject.getTotalCount());
    }

    @Test
    public void testSave2DifferentCars(){
        Car car1 = new Car("abcd1234", 2008, 1);
        Car car2 = new Car("1234abcd", 2007, 3);
        testSubject.save(car1);
        testSubject.save(car2);
        Assertions.assertEquals(2, testSubject.getTotalCount());
    }

    @Test
    public void testSave2DifferentCars2Times(){
        Car car1 = new Car("abcd1234", 2008, 1);
        Car car2 = new Car("1234abcd", 2007, 3);
        Car car3 = new Car("abcd1234", 2008, 1);
        Car car4 = new Car("1234abcd", 2007, 3);
        testSubject.save(car1);
        testSubject.save(car2);
        testSubject.save(car3);
        testSubject.save(car4);
        Assertions.assertEquals(2, testSubject.getTotalCount());
    }

    @Test
    public void findByVinWhenTotalCountIs0(){
        Car car = testSubject.findByVin("aw57q");
        Assertions.assertNull(car);
    }

    @Test
    public void findByVinWhenCarExists(){
        Car car1 = new Car("abcd1234", 2008, 1);
        testSubject.save(car1);
        Assertions.assertEquals(car1, testSubject.findByVin("abcd1234"));
    }

    @Test
    public void testGetTotalCountWhenThereIsNoSavedCar(){
        Assertions.assertEquals(0, testSubject.getTotalCount());
    }

}