package com.aca.homework.week15.service.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    public void testEqualsWhenUsersAreEqual() {
        Assertions.assertEquals(new User("a", "b"), new User("a", "b"));
    }

    @Test
    public void testEqualsWhenUsersAreNotEqual() {
        Assertions.assertNotEquals(new User("b", "a"), new User("a", "b"));
    }

    @Test
    public void testHashCodeWhenUsersAreEqual() {
        Assertions.assertEquals(new User("a", "b").hashCode(), new User("a", "b").hashCode());
    }

    @Test
    public void testClassAnnotatedAsTable() {
        Assertions.assertNotNull(User.class.getDeclaredAnnotation(Table.class));
    }

    @Test
    public void testClassFieldsAnnotatedAsColumn() {
        try {
            Assertions.assertNotNull(User.class.getDeclaredField("name").getDeclaredAnnotation(Column.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        try {
            Assertions.assertNotNull(User.class.getDeclaredField("username").getDeclaredAnnotation(Column.class));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}