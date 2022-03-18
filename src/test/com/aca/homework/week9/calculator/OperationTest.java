package com.aca.homework.week9.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OperationTest {
    @Test
    public void testOfWhenOperationIsAddition(){
        Assertions.assertEquals(Operation.ADDITION, Operation.of('+'));
    }

    @Test
    public void testOfWhenOperationIsSubtraction(){
        Assertions.assertEquals(Operation.SUBTRACTION, Operation.of('-'));
    }

    @Test
    public void testOfWhenOperationIsDivision(){
        Assertions.assertEquals(Operation.DIVISION, Operation.of('/'));
    }

    @Test
    public void testofWhenOperationIsMultiplication(){
        Assertions.assertEquals(Operation.MULTIPLICATION, Operation.of('*'));
    }

    @Test
    public void testIsOperationWhenOperationIsAddition(){
        Assertions.assertTrue(Operation.isOperation('+'));
    }

    @Test
    public void testIsOperationWhenOperationIsSubtraction(){
        Assertions.assertTrue(Operation.isOperation('-'));
    }

    @Test
    public void testIsOperationWhenOperationIsDivision(){
        Assertions.assertTrue(Operation.isOperation('/'));
    }

    @Test
    public void testIsOperationWhenOperationIsMultiplication(){
        Assertions.assertTrue(Operation.isOperation('*'));
    }

    @Test
    public void testIsOperationWhenOperationIsInvalid(){
        Assertions.assertFalse(Operation.isOperation('a'));
    }

    @Test
    public void testPerformOperationWhenOperationIsAddition(){
        Assertions.assertEquals("4", Operation.ADDITION.performOperation(3, 1));
    }

    @Test
    public void testPerformOperationWhenOperationIsSubtraction(){
        Assertions.assertEquals("2", Operation.SUBTRACTION.performOperation(3, 1));
    }

    @Test
    public void testPerformOperationWhenOperationIsMultiplication(){
        Assertions.assertEquals("6", Operation.MULTIPLICATION.performOperation(3, 2));
    }

    @Test
    public void testPerformOperationWhenOperationIsDivision(){
        Assertions.assertEquals("6.0", Operation.DIVISION.performOperation(18, 3));
    }

    @Test
    public void testPerformOperationWhenOperationIsDivisionAndResultIsFloat(){
        Assertions.assertEquals("0.5", Operation.DIVISION.performOperation(2, 4));
    }
}