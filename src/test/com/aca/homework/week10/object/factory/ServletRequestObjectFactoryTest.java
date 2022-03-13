package com.aca.homework.week10.object.factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServletRequestObjectFactoryTest {
    private ServletRequestObjectFactory<ServletRequestImpl> testSubject;

    @BeforeEach
    public void setUp(){
        testSubject = new ServletRequestObjectFactory<>();
    }

    @Test
    public void testSingGetObject(){
        Assertions.assertNotNull(testSubject.getObject());
    }

    @Test
    public void testGet2Objects(){
        Assertions.assertNotEquals(testSubject.getObject(), testSubject.getObject());
    }
    @Test
    public void testGet3Objetcs(){
        ServletRequest servletRequest1 = testSubject.getObject();
        ServletRequest servletRequest2 = testSubject.getObject();
        ServletRequest servletRequest3 = testSubject.getObject();
        Assertions.assertNotEquals(servletRequest1, servletRequest3);
        Assertions.assertNotEquals(servletRequest1, servletRequest2);
        Assertions.assertNotEquals(servletRequest2, servletRequest3);
    }
}