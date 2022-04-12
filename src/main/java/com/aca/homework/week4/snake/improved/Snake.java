package com.aca.homework.week4.snake.improved;

import java.util.Scanner;

public class Snake {
    private final int size = 1;
    private final BodyCell snakeHead;

    public Snake(int headRow, int headCol) {
        snakeHead = new BodyCell(headRow, headCol, CellType.HEAD, null);
    }

    public BodyCell getHead() {
        return snakeHead;
    }

    public boolean isOutOfBounds(int dirX, int dirY, Board board) {
        int newRow = snakeHead.getRow() + dirY;
        int newCol = snakeHead.getCol() + dirX;

        return newRow >= 0 && newRow < board.getRowCount() && newCol >= 0 && newCol < board.getColCount();
    }

    public boolean eatsAppleOnNextMove(int dirX, int dirY, Apple apple) {
        return snakeHead.getRow() + dirY == apple.getRow() && snakeHead.getCol() + dirX == apple.getCol();
    }

    public boolean ateAppleOnPrevMove(int dirX, int dirY) {
        return false;
    }

    public void update(int dirX, int dirY) {
        BodyCell start = snakeHead.getNext();
        while (start != null) {
            BodyCell next = start.getNext();
            next.setRow(start.getRow());
            next.setCol(start.getCol());
            start = start.getNext();
        }
        snakeHead.setRow(snakeHead.getRow() + dirY);
        snakeHead.setCol(snakeHead.getCol() + dirX);
    }

}
