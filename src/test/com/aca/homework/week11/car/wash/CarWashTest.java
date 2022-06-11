package com.aca.homework.week11.car.wash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CarWashTest {

    private CarRepositoryForTest carRepo;

    @BeforeEach
    public void setUp() {
        carRepo = new CarRepositoryForTest("JILLY'S");
    }

    @Test
    public void testWash1Time() {
        String[] inputs = {"111AA11"};
        carRepo.save(inputs);
        carRepo.wash();
        Assertions.assertEquals(Map.of(
                "111AA11", 1
        ), carRepo.load());
    }

    @Test
    public void testWash5Times() {
        String[] inputs = {"111AA11", "111AA11", "111AA11", "111AA11", "111AA11"};
        carRepo.save(inputs);
        carRepo.wash();
        carRepo.wash();
        carRepo.wash();
        carRepo.wash();
        carRepo.wash();
        Assertions.assertEquals(Map.of(
                "111AA11", 0
        ), carRepo.load());
    }

    @Test
    public void testWash6Times() {
        String[] inputs = {"111AA11", "111AA11", "111AA11", "111AA11", "111AA11", "111AA11"};
        carRepo.save(inputs);
        carRepo.wash();
        carRepo.wash();
        carRepo.wash();
        carRepo.wash();
        carRepo.wash();
        carRepo.wash();
        Assertions.assertEquals(Map.of(
                "111AA11", 1
        ), carRepo.load());
    }

    @Test
    public void testWash10Times() {
        String[] inputs = {"111AA11", "111AA11", "111AA11", "111AA11", "111AA11", "111AA11", "111AA11", "111AA11", "111AA11", "111AA11"};
        carRepo.save(inputs);
        for (int i = 0; i < 10; i++) {
            carRepo.wash();
        }
        Assertions.assertEquals(Map.of(
                "111AA11", 0
        ), carRepo.load());
    }

    @Test
    public void testName() {
        Assertions.assertEquals("JILLY'S", carRepo.name());
    }
}