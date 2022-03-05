package com.aca.homework.week9.tuple2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Tuple2Test {
    @Test
    public void testTuple2ForStringAndInteger(){
        Tuple2<String, Integer> tuple2 = new Tuple2<>("text", 45);
        Assertions.assertEquals("text", tuple2.getT1());
        Assertions.assertEquals(45, tuple2.getT2());
    }

    @Test
    public void testTuple2ForLongAndInteger(){
        Tuple2<Long, Integer> tuple2 = new Tuple2<>(100L, 45);
        Assertions.assertEquals(100, tuple2.getT1());
        Assertions.assertEquals(45, tuple2.getT2());
    }
}