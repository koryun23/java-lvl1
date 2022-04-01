package com.aca.homework.week12.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppleTest {

    private Apple testSubject;
    private Board board;

    @BeforeEach
    public void setUp() {
        testSubject = new Apple(2, 1);
        board = new Board(8, 8, testSubject, new Snake(0, 0));
    }

    @Test
    public void testGenerate() {
        testSubject.generate(board);
        Assertions.assertFalse(testSubject.getRow() == 2 && testSubject.getCol() == 1);
    }
}