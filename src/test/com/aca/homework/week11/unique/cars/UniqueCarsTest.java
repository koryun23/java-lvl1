package com.aca.homework.week11.unique.cars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Set;

class UniqueCarsTest {
    @Test
    public void testAskAndCalculate() {
        String[] inputs = {"John bmw 7", "Jack opel astra", "Mary bmw 7", "finish"};
        UniqueCars uniqueCars = new UniqueCars(new StringSupplierForTest(inputs));

        Assertions.assertEquals(
                Set.of(
                        new Car("bmw", "7"), new Car("opel", "astra")
                ), uniqueCars.askAndCalculate());
    }

    @Test
    public void testInvalidInputException() {
        String[] inputs = {"John bmw", "finish"};
        UniqueCars uniqueCars = new UniqueCars(new StringSupplierForTest(inputs));
        Assertions.assertThrows(InvalidInputException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                uniqueCars.askAndCalculate();
            }
        });
    }
}