package com.aca.homework.week15.service.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserCreateParamsTest {
    @Test
    public void testEqualsWhenUsersAreEqual() {
        Assertions.assertEquals(new UserCreateParams("a", "b"), new UserCreateParams("a", "b"));
    }

    @Test
    public void testEqualsWhenUsersAreNotEqual() {
        Assertions.assertNotEquals(new UserCreateParams("b", "a"), new UserCreateParams("a", "b"));
    }

    @Test
    public void testHashCodeWhenUsersAreEqual() {
        Assertions.assertEquals(new UserCreateParams("a", "b").hashCode(), new UserCreateParams("a", "b").hashCode());
    }
}