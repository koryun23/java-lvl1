package com.aca.homework.week10.mapper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultUserMapperTest {
    private UserMapper testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new DefaultUserMapper();
    }

    @Test
    public void testMap() {
        UserModel userModel = testSubject.map(new User(1, "student", "Lord"));
        Assertions.assertEquals("Lord", userModel.getFirstName());
        Assertions.assertEquals("student", userModel.getUsername());
    }
}