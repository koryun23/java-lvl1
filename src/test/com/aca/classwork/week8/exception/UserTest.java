package com.aca.classwork.week8.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class UserTest {
    @Test
    public void testWhenUsernameIsNull() {
        RuntimeException exception = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new User(null, "first name");
            }
        });

        Assertions.assertEquals("Username is null", exception.getMessage());
    }

    @Test
    public void testWhenFirstNameIsNull() {
        RuntimeException exception = Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                new User("username", null);
            }
        });

        Assertions.assertEquals("First name is null", exception.getMessage());
    }
}
