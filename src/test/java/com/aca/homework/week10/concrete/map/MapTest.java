package com.aca.homework.week10.concrete.map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class MapTest {
    private Map map;

    @BeforeEach
    public void setUp(){
        map = new Map();
    }

    @Test
    public void testPutWhenKeyIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                map.put(null, "value");
            }
        });
    }
    @Test
    public void testPutWhenValueIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                map.put("key", null);
            }
        });
    }

    @Test
    public void testGetValueWhenValueIsNull(){
        Assertions.assertNull(map.getValue(null));
    }

    @Test
    public void testValueWhenKeyIsNotFound(){
        Assertions.assertNull(map.getValue("uoisadf"));
    }

    @Test
    public void testValueWhenKeyIsFound(){
        map.put("key", "value");
        Assertions.assertEquals("value", map.getValue("key"));
    }

    @Test
    public void testSizeWhenEmpty(){
        Assertions.assertEquals(0, map.size());
    }

    @Test
    public void testSizeWhen1PairIsAdded(){
        map.put("key", "value");
        Assertions.assertEquals(1, map.size());
    }
}