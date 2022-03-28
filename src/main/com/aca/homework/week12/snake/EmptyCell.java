package com.aca.homework.week12.snake;

public class EmptyCell extends Cell{

    public EmptyCell(int row, int col) {
        super(row, col, CellState.EMPTY);
    }

    @Override
    public CellState getState(){
        return CellState.EMPTY;
    }
}
