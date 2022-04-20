package com.aca.homework.week13.race.condition.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceConditionGeneratorTest {
    private RaceConditionGenerator testSubject;

    @BeforeEach
    public void init() {
        testSubject = new RaceConditionGenerator(() -> true);
    }

    @Test
    public void testStart() {
        Assertions.assertEquals(10000, testSubject.start());
    }

}