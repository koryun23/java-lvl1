package com.aca.homework.week4.snake.improved;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Snake snake = new Snake(0, 0);
        Apple apple = new Apple(2, 1);
        Board board = new Board(snake, apple);
        board.print();
    }
}
