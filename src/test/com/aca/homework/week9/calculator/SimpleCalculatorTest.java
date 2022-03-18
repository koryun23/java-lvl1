package com.aca.homework.week9.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleCalculatorTest {
    private SimpleCalculator testSubject;

    @Test
    public void testWhenInputStringLengthIs1() {
        testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "1";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs2() {
        testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "1/";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenInputStringLengthIs4() {
        testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "1/34";
            }
        });
        Assertions.assertEquals("error", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsSum() {
        testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "4+2";
            }
        });
        Assertions.assertEquals("6", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsDivision() {
        testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "2/4";
            }
        });
        Assertions.assertEquals("0.5", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsSubtraction() {
        testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "4-2";
            }
        });
        Assertions.assertEquals("2", testSubject.askAndCalculate());
    }

    @Test
    public void testWhenOperationIsMultiplication() {
        testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "4*2";
            }
        });
        Assertions.assertEquals("8", testSubject.askAndCalculate());
    }

    @Test
    public void testIsDigitForDigitsFrom0To9(){
        testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "4+2";
            }
        });
        Assertions.assertTrue(testSubject.isDigit('0'));
        Assertions.assertTrue(testSubject.isDigit('1'));
        Assertions.assertTrue(testSubject.isDigit('2'));
        Assertions.assertTrue(testSubject.isDigit('3'));
        Assertions.assertTrue(testSubject.isDigit('4'));
        Assertions.assertTrue(testSubject.isDigit('5'));
        Assertions.assertTrue(testSubject.isDigit('6'));
        Assertions.assertTrue(testSubject.isDigit('7'));
        Assertions.assertTrue(testSubject.isDigit('8'));
        Assertions.assertTrue(testSubject.isDigit('9'));
    }
    @Test
    public void testIsDigitForNonDigitCharacters(){
        testSubject = new SimpleCalculator(new StringSupplier() {
            @Override
            public String get() {
                return "4+2";
            }
        });
        Assertions.assertFalse(testSubject.isDigit('='));
    }
}