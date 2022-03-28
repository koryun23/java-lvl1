package com.aca.homework.week11.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingerTest {
    @Test
    public void testEqualsAndHashCodeWhen2SingersAreTheSame(){
        Singer singer1 = new Singer("abc", "bdc");
        Singer singer2 = new Singer("abc", "bdc");
        Assertions.assertEquals(singer1, singer2);
        Assertions.assertEquals(singer1.hashCode(), singer2.hashCode());
    }

    @Test
    public void testEqualsWhen2SingersAreNotTheSame(){
        Assertions.assertNotEquals(new Singer("abc", "abc"), new Singer("xyz", "xyz"));
    }
}