package com.aca.homework.week12.snake;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private final Cell[][] cells;
    private final Snake snake;
    private final Apple apple;
    private final int rowCount;
    private final int colCount;

    public Board(int rowCount, int colCount, Apple apple, Snake snake) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.apple = apple;
        this.snake = snake;
        cells = new Cell[rowCount][colCount];
        setAllEmpty();
        setApple();
        setSnake();
    }

    public Snake getSnake() {
        return snake;
    }

    public Apple getApple() {
        return apple;
    }


    public void setApple() {
        cells[apple.getRow()][apple.getCol()] = apple;
    }

    public void setAllEmpty() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                cells[i][j] = new EmptyCell(i, j);
            }
        }
    }

    public void setSnake() {
        SnakeHead head = snake.snakeHead();
        cells[head.getRow()][head.getCol()] = new SnakeHead(head.getRow(), head.getCol());
        while (head.next() != null) {
            SnakeBodyCell nextBodyCell = head.next();
            cells[nextBodyCell.getRow()][nextBodyCell.getCol()] = nextBodyCell;
        }
    }

    public void print() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                System.out.print(cells[i][j].toString() + " ");
            }
            System.out.println();
        }
    }

    public void updateBoard() {
        setAllEmpty();
        updateAppleOnBoard();
        updateSnakeOnBoard();
    }

    public void updateSnakeOnBoard() {
        List<SnakeBodyCell> coords = snake.snakeCoords();
        for (SnakeBodyCell bodyCell : coords) {
            cells[bodyCell.getRow()][bodyCell.getCol()] = bodyCell;
        }
        cells[coords.get(0).getRow()][coords.get(0).getCol()] = coords.get(0);
    }

    public void updateAppleOnBoard() {
        cells[apple.getRow()][apple.getCol()] = apple;
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColCount() {
        return colCount;
    }

    public Cell[][] getCells() {
        return cells.clone();
    }

    public List<Cell> emptyCells() {
        List<Cell> emptyCells = new LinkedList<>();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (cells[i][j].getState() == CellState.EMPTY) {
                    emptyCells.add(cells[i][j]);
                }
            }
        }
        return emptyCells;
    }
}
