package com.aca.homework.week12.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    public void testIsValidMoveWhenMoveIsW(){
        Assertions.assertTrue(Direction.isValidMove("w"));
    }

    @Test
    public void testIsValidMoveWhenMoveIsA(){
        Assertions.assertTrue(Direction.isValidMove("a"));
    }

    @Test
    public void testIsValidMoveWhenMoveIsD(){
        Assertions.assertTrue(Direction.isValidMove("d"));
    }

    @Test
    public void testIsValidMoveWhenMoveIsS(){
        Assertions.assertTrue(Direction.isValidMove("s"));
    }

    @Test
    public void testIsValidMoveWhenInputIsEmpty(){
        Assertions.assertFalse(Direction.isValidMove(""));
    }

    @Test
    public void testIsValidMoveWhenInputIsNull(){
        Assertions.assertFalse(Direction.isValidMove(null));
    }

    @Test
    public void testIsValidMoveWhenInputIsInvalidMove(){
        Assertions.assertFalse(Direction.isValidMove("j"));
    }

    @Test
    public void testOfWhenMoveIsA(){
        Assertions.assertEquals(Direction.LEFT, Direction.of("a"));
    }

    @Test
    public void testOfWhenMoveIsD(){
        Assertions.assertEquals(Direction.RIGHT, Direction.of("d"));
    }

    @Test
    public void testOfWhenMoveIsS(){
        Assertions.assertEquals(Direction.DOWN, Direction.of("s"));
    }

    @Test
    public void testOfWhenMoveIsW(){
        Assertions.assertEquals(Direction.UP, Direction.of("w"));
    }

    @Test
    public void testOfWhenMoveIsEmptyString(){
        Assertions.assertNull(Direction.of(""));
    }

    @Test
    public void testOfWhenMoveIsNull(){
        Assertions.assertNull(Direction.of(null));
    }
}