package com.aca.homework.week6.tictactoe;

public class Board {
    private final int rowCount = 3;
    private final int columnCount = 3;
    private final BoardPixel[][] board = new BoardPixel[rowCount][columnCount];

    public Board() {
        generateEmptyBoard();
    }

    public void generateEmptyBoard() {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                board[i][j] = new BoardPixel(State.EMPTY);
            }
        }
    }

    public BoardPixel[][] getBoard() {
        return board;
    }

    public void printColumnNumbers() {
        System.out.print("  ");
        for (int i = 0; i < columnCount; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();
        System.out.println("  ------");
    }

    public void print() {
        printColumnNumbers();
        for (int i = 0; i < rowCount; i++) {
            System.out.print((i + 1) + "|");
            for (int j = 0; j < columnCount; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public BoardPixel getBoardPixel(int i, int j) {
        return board[i][j];
    }
}
