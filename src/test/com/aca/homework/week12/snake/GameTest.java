package com.aca.homework.week12.snake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    private final Board board = new Board(8,8, new Apple(2, 1), new Snake(0, 0));

    @Test
    public void testSnakeHitEdgeOfBoardFromLeft(){
        String[] moves = {"a"};
        Game game = new Game(board, new MoveSupplierForTest(moves));
        game.start();
        Assertions.assertEquals(GameState.TERMINATED, game.getState());
    }

    @Test
    public void testSnakeHitEdgeOfBoardFromTop(){
        String[] moves = {"w"};
        Game game = new Game(board, new MoveSupplierForTest(moves));
        game.start();
        Assertions.assertEquals(GameState.TERMINATED, game.getState());
    }

    @Test
    public void testSnakeHitEdgeOfBoardFromRight(){
        String[] moves = {"d", "d", "d", "d", "d", "d", "d", "d"};
        Game game = new Game(board, new MoveSupplierForTest(moves));
        game.start();
        Assertions.assertEquals(GameState.TERMINATED, game.getState());
    }

    @Test
    public void testSnakeHitEdgeOfBoardFromBottom(){
        String[] moves = {"s", "s", "s", "s", "s", "s", "s", "s"};
        Game game = new Game(board, new MoveSupplierForTest(moves));
        game.start();
        Assertions.assertEquals(GameState.TERMINATED, game.getState());
    }

    @Test
    public void testGameStateWhenSnakeDidNotHitEdgeOfBoard(){
        String[] moves = {"s", "s", "s", "s", "d", "d", "d"};
        Game game = new Game(board, new MoveSupplierForTest(moves));
        game.start();
        Assertions.assertEquals(GameState.RUNNING, game.getState());
    }
}