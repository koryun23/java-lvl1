package com.aca.homework.week12.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {
    private Snake testSubject;

    @BeforeEach
    public void setUp(){
        testSubject = new Snake(0, 0);
    }

    @Test
    public void testMoveWhenDeltaRowIs1AndDeltaColIs0() {
        testSubject.move(1, 0);
        Assertions.assertEquals(1, testSubject.snakeHead().getRow());
        Assertions.assertEquals(0, testSubject.snakeHead().getCol());
        Assertions.assertFalse(testSubject.headOutOfBounds(8,8));
    }

    @Test
    public void testMoveWhenDeltaRowIs0AndDeltaColIs1() {
        testSubject.move(0, 1);
        Assertions.assertEquals(0, testSubject.snakeHead().getRow());
        Assertions.assertEquals(1, testSubject.snakeHead().getCol());
        Assertions.assertFalse(testSubject.headOutOfBounds(8,8));
    }

    @Test
    public void testMoveWhenDeltaRowIsNegativeAndDeltaColIs0(){
        testSubject.move(-1, 0);
        Assertions.assertTrue(testSubject.headOutOfBounds(8, 8));
    }

    @Test
    public void testMoveWhenDeltaRowis0AndDeltaColIsNegative(){
        testSubject.move(0, -1);
        Assertions.assertTrue(testSubject.headOutOfBounds(8, 8));
    }
}