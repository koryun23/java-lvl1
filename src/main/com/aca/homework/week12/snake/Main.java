package com.aca.homework.week12.snake;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(8,8, new Apple(2, 1), new Snake(0, 0));
        Game game = new Game(board);
        game.start();
    }
}
