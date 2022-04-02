package com.aca.homework.week12.params;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserUpdateParamsTest {
    @Test
    public void testNewUserWithInvalidUsername() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserUpdateParams(null, "firstname", 34));
    }

    @Test
    public void testNewUserWithInvalidFirstName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserUpdateParams("username", null, 34));
    }

    @Test
    public void testNewUserWithInvalidAge() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserUpdateParams("username", "firstname", -1));
    }

    @Test
    public void testNewUserWithValidParameters() {
        Assertions.assertDoesNotThrow(() -> new UserUpdateParams("username", "firstname", 32));
    }
}