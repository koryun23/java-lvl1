package com.aca.homework.week8.checked.unchecked.exceptions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCarsTest {
    @Test
    public void testMethod1() {
        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() {
                Main.method1();
            }
        });
    }

    @Test
    public void testMethod2() {
        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() {
                Main.method2();
            }
        });
    }

    @Test
    public void testMethod3() {
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() {
                Main.method3();
            }
        });
    }

    @Test
    public void testMethod4() {
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method4();
            }
        });
    }

    @Test
    public void testMethod5() {
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Main.method5();
            }
        });
    }
}