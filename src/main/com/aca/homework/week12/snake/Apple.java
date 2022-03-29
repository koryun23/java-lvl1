package com.aca.homework.week12.snake;

import java.util.List;
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
        List<Cell> emptyCells = board.emptyCells();
        System.out.println(emptyCells.size());
        Random generator = new Random();
        Cell cell = emptyCells.get(generator.nextInt(emptyCells.size()));
        setRow(cell.getRow());
        setCol(cell.getCol());
        cell.setState(CellState.APPLE);
    }
}
