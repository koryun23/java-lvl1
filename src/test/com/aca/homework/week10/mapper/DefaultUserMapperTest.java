package com.aca.homework.week10.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultUserMapperTest {
    private UserModel testSubject;
    @BeforeEach
    public void setUp(){
        testSubject = new DefaultUserMapper().map(new User(1, "student", "Lord"));
    }
    @Test
    public void testMap(){
        Assertions.assertEquals("Lord", testSubject.getFirstName());
        Assertions.assertEquals("student", testSubject.getUsername());
    }
}