package com.aca.homework.week12.snake;

import java.util.LinkedList;
import java.util.List;

public class Snake { // Snake is basically a linked list

    private SnakeHead head;

    public Snake(int headRow, int headCol){
        head = new SnakeHead(headRow, headCol);
    }

    public void extend(int newHeadRow, int newHeadCol){
        SnakeBodyCell newBodyCell = new SnakeBodyCell(head.getRow(), head.getCol(), CellState.SNAKE_BODY);
        head.setRow(newHeadRow);
        head.setCol(newHeadCol);
        newBodyCell.setNext(head.next());
        head.setNext(newBodyCell);
    }

    public SnakeHead snakeHead(){
        return head;
    }
}
