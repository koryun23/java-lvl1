package com.aca.homework.week6.tictactoe;

import java.util.Scanner;

public class Game {
    private final Board board = new Board();
    private final User[] users = new User[2];
    private final State[] stateForEachUser = {State.X, State.O};
    private int currentTurn = 0;
    private int moves = 0;
    private boolean isWin;
    private boolean noEmptyBoardPixelsExist;
    public void startGame() {
        System.out.println("Tic-Tac-Toe started!");
        User user1 = registerFirstUser();
        User user2 = registerSecondUser();
        users[0] = user1;
        users[1] = user2;
        while (!isWin && !noEmptyBoardPixelsExist) {
            board.print();
            askForMove();
            Coordinate coords = getCoordinates();
            if (coords != null) {
                int xCoord = coords.getX();
                int yCoord = coords.getY();
                board.getBoardPixel(yCoord - 1, xCoord - 1).setBoardPixel(stateForEachUser[currentTurn]);
                moves++;
                switchTurn();
                isWin = isWin();
                noEmptyBoardPixelsExist = noEmptyBoardPixelsExist();
            } else {
                System.out.println("Please try again");
            }
        }
        board.print();
        switchTurn();
        if(isWin) {
            System.out.printf("Congratulations %s! You won", users[currentTurn].getUsername());
        }else{
            System.out.println("Game ended in a draw.");
        }
    }

    private boolean noEmptyBoardPixelsExist() {
        return moves == 9;
    }

    public User registerFirstUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the first user.");
        String usernameOfFirstUser = scanner.nextLine();
        return new User(usernameOfFirstUser);
    }

    public User registerSecondUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the second user.");
        String usernameOfSecondUser = scanner.nextLine();
        return new User(usernameOfSecondUser);
    }

    public void askForMove() {
        System.out.printf("Dear %s it's your turn, enter the coordinates in format (x,y)\n", users[currentTurn].getUsername());
    }

    public void switchTurn() {
        currentTurn = 1 - currentTurn;
    }

    public Coordinate getCoordinates() {
        Scanner scanner = new Scanner(System.in);
        String coordinate = scanner.nextLine();
        if (!isValidCoordinate(coordinate)) {
            return null;
        }
        int numericValueOfXCoord = coordinate.charAt(1) - 48;
        int numericValueOfYCoord = coordinate.charAt(3) - 48;
        if(boardPixelNotEmpty(numericValueOfXCoord, numericValueOfYCoord)){
            return null;
        }
        return new Coordinate(numericValueOfXCoord, numericValueOfYCoord);
    }

    public boolean isValidCoordinate(String coordinate) {
        return !(coordinate.charAt(0) != '(' || coordinate.charAt(4) != ')' || coordinate.charAt(2) != ',' || coordinate.charAt(1) < 48 || coordinate.charAt(1) > 57 || coordinate.charAt(3) < 48 || coordinate.charAt(3) > 57);
    }

    public boolean boardPixelNotEmpty(int x, int y){
        return board.getBoardPixel(y-1, x-1).getState() != State.EMPTY;
    }

    public boolean isWin() {
        return moves >= 5 && (checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin());
    }

    public boolean checkVerticalWin() {
        for (int i = 0; i < board.getRowCount(); i++) {
            if (board.getBoardPixel(i, 0).equals(board.getBoardPixel(i, 1)) && board.getBoardPixel(i, 0).equals(board.getBoardPixel(i, 2))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkHorizontalWin() {
        for (int i = 0; i < board.getColumnCount(); i++) {
            if (board.getBoardPixel(0, i).equals(board.getBoardPixel(1, i)) && board.getBoardPixel(0, i).equals(board.getBoardPixel(2, i))) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonalWin(){
        BoardPixel center = board.getBoardPixel(1,1);
        BoardPixel topLeft = board.getBoardPixel(0,0);
        BoardPixel bottomRight = board.getBoardPixel(2,2);
        if(topLeft.equals(center) && topLeft.equals(bottomRight) && center.equals(bottomRight)){
            System.out.println(topLeft);
            System.out.println(center);
            System.out.println(bottomRight);
            return true;
        }

        BoardPixel topRight = board.getBoardPixel(0, 2);
        BoardPixel bottomLeft = board.getBoardPixel(2,0);
        if(topRight.equals(center) && topRight.equals(bottomLeft) && center.equals(bottomLeft)){
            System.out.println(topRight);
            System.out.println(center);
            System.out.println(bottomLeft);
            return true;
        }
        return false;
    }


}
