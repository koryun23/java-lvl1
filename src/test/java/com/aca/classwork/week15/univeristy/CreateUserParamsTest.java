package com.aca.classwork.week15.univeristy;

import com.aca.classwork.week15.university.service.core.CreateUserParams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class CreateUserParamsTest {

    @Test
    public void testInvalidFirstName() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams("username", null, "second name", LocalDate.now()))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testInvalidSecondName() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams("username", "first name", null, LocalDate.now()))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testNullUsername() {
        Assertions.assertThatThrownBy(() -> new CreateUserParams(null, "firstname", "secondName", LocalDate.now()))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}