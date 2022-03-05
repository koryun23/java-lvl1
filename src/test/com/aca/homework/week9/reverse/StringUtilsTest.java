package com.aca.homework.week9.reverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class StringUtilsTest {
    @Test
    public void testReverseWhenArgumentIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                StringUtils.reverse(null);
            }
        });
    }

    @Test
    public void testReverseWhenLengthIs1() {
        Assertions.assertEquals("a", StringUtils.reverse("a"));
    }

    @Test
    public void testReverse() {
        Assertions.assertEquals("qwerty", StringUtils.reverse("ytrewq"));
    }
}