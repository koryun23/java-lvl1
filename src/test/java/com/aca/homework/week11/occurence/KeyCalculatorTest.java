package com.aca.homework.week11.occurence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class KeyCalculatorTest {
    @Test
    public void testKeyCalculator() {
        Supplier supplier = new SupplierForTest(new String[]{"1", "1", "2", "3", "4", "end"});
        KeyCalculator keyCalculator = new KeyCalculator(supplier);
        Map<Integer, Integer> map = keyCalculator.getOccurrences();
        Assertions.assertEquals(2, map.get(1));
        Assertions.assertEquals(1, map.get(2));
        Assertions.assertEquals(1, map.get(2));
        Assertions.assertEquals(1, map.get(4));
    }

    @Test
    public void testKeyCalculatorWhenAllNumbersAreSame() {
        Supplier supplier = new SupplierForTest(new String[]{"1", "1", "1", "1", "end"});
        Assertions.assertEquals(4, new KeyCalculator(supplier).getOccurrences().get(1));
    }

    @Test
    public void testKeyCalculatorWhenNoNumbersAreGiven() {
        Supplier supplier = new SupplierForTest(new String[]{"end"});
        Assertions.assertEquals(0, new KeyCalculator(supplier).getOccurrences().size());
    }
}