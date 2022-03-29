package com.aca.homework.week12.snake;

import java.util.Random;

public class Apple extends Cell{

    public Apple(int row, int col) {
        super(row, col, CellState.APPLE);
    }

    @Override
    public CellState getState(){
        return CellState.APPLE;
    }

    public void generate(Board board){
        Random generator = new Random();
        int newRow, newCol;
        do {
            newRow = generator.nextInt(board.getRowCount());
            newCol = generator.nextInt(board.getColCount());
        } while(board.getCells()[newRow][newCol].getState() != CellState.EMPTY);
        setRow(newRow);
        setCol(newCol);
    }
}
