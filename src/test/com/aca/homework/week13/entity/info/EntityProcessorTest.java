package com.aca.homework.week13.entity.info;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityProcessorTest {

    private EntityProcessor testSubject;

    @BeforeEach
    public void setUp(){
        testSubject = new EntityProcessor();
    }

    @Test
    public void testWhenObjectIsProduct(){
        Assertions.assertEquals("table name is: PRODUCT, id is 10, NAME is box", testSubject.getInfo(new Product(10L, "box")));
    }

    @Test
    public void testWhenObjectIsString(){
        Assertions.assertEquals("", testSubject.getInfo("some random string"));
    }
}