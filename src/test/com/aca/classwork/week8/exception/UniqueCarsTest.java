package com.aca.classwork.week8.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class UniqueCarsTest {
    @Test
    public void test() {
        Assertions.assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() {
                Main.main(null);
            }
        });
    }
}
