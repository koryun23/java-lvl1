package com.aca.homework.week12.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserCreateParamsTest {

    @Test
    public void testNewUserWithInvalidUsername() {
        Assertions.assertThrows(NullPointerException.class, () -> new UserCreateParams(null, "firstname", 34));
    }

    @Test
    public void testNewUserWithInvalidFirstName() {
        Assertions.assertThrows(NullPointerException.class, () -> new UserCreateParams("username", null, 34));
    }

    @Test
    public void testNewUserWithInvalidAge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserCreateParams("username", "firstname", -1));
    }

    @Test
    public void testNewUserWithValidParameters() {
        Assertions.assertDoesNotThrow(() -> new UserCreateParams("username", "firstname", 32));
    }
}