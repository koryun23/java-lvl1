package com.aca.homework.week4.snake.improved;

import java.util.Random;

public class Apple extends Cell{
    public Apple(int row, int col){
        super(row, col);
    }

    public static int generateNewRow(){
        return new Random().nextInt(8);
    }
    public static int generateNewCol(){
        return new Random().nextInt(8);
    }
    public Apple generateNewApple(Board board){
        int randomRow = generateNewRow();
        int randomCol = generateNewCol();
        while(board.getBoard()[randomRow][randomCol].getType() != CellType.EMPTY){
            randomRow = generateNewRow();
            randomCol = generateNewCol();
        }
        return new Apple(randomRow, randomCol);
    }
    @Override
    public CellType getType(){
        return CellType.APPLE;
    }

    @Override
    public String toString(){
        return Colors.YELLOW + "=" + Colors.RESET;
    }


}
