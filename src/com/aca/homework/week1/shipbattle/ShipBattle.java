package com.aca.homework.week1.shipbattle;

import java.util.Scanner;

public class ShipBattle {
    public static void main(String[] args) {
        char[][] board = new char[10][10];
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = '.';
            }
        }
        placeShips(board);
        for(int i = 0; i < 20; i++) {
            if (!shoot(board)){
                i--;
            }

        }
    }
    public static boolean shoot(char[][] board){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the x coordinates of the block you want to shoot");
        int x = scanner.nextInt();
        System.out.println("Write the y coordinates of the block you want to shoot");
        int y = scanner.nextInt();
        if(board[9-y][x] == '#'){
            board[9-y][x] = 'O';
            showBoard(board);
            return true;
        }
        board[9-y][x] = 'X';
        return false;
    }
    public static int numOfAdjacentBlocks(char[][] board, int i, int j){
        int[][] directions = {
                {i-1,j-1},
                {i-1, j},
                {i-1, j+1},
                {i, j-1},
                {i, j+1},
                {i+1, j-1},
                {i+1, j},
                {i+1, j+1}
        };
        int counter = 0;
        for(int[] dir : directions){
            if (dir[0] >= 0 && dir[0] < 10 && dir[1] >= 0 && dir[1] < 10){
                // then the cell is inside the board
                // we check if there is a block of ship in that cell
                char currentCell = board[9-dir[1]][dir[0]];
                if(currentCell == '#'){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void placeShips(char[][] board) {
        int block1 = 4;
        int block2 = 3;
        int block3 = 2;
        int block4 = 1;
        int startingX = -1, startingY = -1, endingX = -1, endingY = -1, temp=0;
        while (block1 > 0 || block2 > 0 || block3 > 0 || block4 > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter * to see the board, --insert to insert a ship or --reset to reset a ship.");
            String answer = scanner.nextLine();
            if ("--insert".equals(answer)) {
                System.out.println("How many blocks do you want your ship to have(1, 2, 3, 4)");
                int blocks = scanner.nextInt();

                if (blocks == 1) {
                    if (block1 > 0) { // we check if there are less then 4 ships having only 1 block
                        System.out.println("Write the x coordinate for your ship: [0-9]");
                        startingX = scanner.nextInt();
                        System.out.println("Write the y coordinate for your ship: [0-9]");
                        startingY = scanner.nextInt();
                        if (startingX < 0 || startingX > 9 || startingY < 0 || startingY > 9) {
                            System.out.println("Invalid coordinates.");
                        } else if (numOfAdjacentBlocks(board, startingX, startingY) > 0) {
                            System.out.println("Can't place the ship. There is a ship adjacent to the entered coordinates.");
                        }else if(board[9-startingY][startingX] == '#'){
                            System.out.println("Can't plaec the ship. The cell is not epmty.");
                        }
                        else {
                            board[9 - startingY][startingX] = '#'; // place a ship there
                            showBoard(board);
                            block1--;
                        }
                    } else {
                        System.out.println("Can't place the ship.");
                    }
                } else {
                    int block = 0;
                    if (blocks == 2) {
                        block = block2;
                    } else if (blocks == 3) {
                        block = block3;
                    } else if (blocks == 4) {
                        block = block4;
                    }
                    if (block > 0) {
                        System.out.println("Write the x coordinate of the first block of your ship: [0-9]");
                        startingX = scanner.nextInt();
                        System.out.println("Write the y coordinate of the first block of your ship: [0-9]");
                        startingY = scanner.nextInt();

                        System.out.println("Write the x coordinate of the last block of your ship: [0-9]");
                        endingX = scanner.nextInt();
                        System.out.println("Write the y coordinate of the last block of your ship: [0-9]");
                        endingY = scanner.nextInt();
                        boolean hasAdjacentBlocks = false;
                        temp = 0;
                        if (startingY > endingY) { // swap 'em
                            temp = startingY;
                            startingY = endingY;
                            endingY = temp;
                        }
                        if (startingX > endingX) {  // swap 'em
                            temp = startingX;
                            startingX = endingX;
                            endingX = temp;
                        }
                        if(validCoords(startingX, startingY) && validCoords(endingX, endingY)) {
                            if (startingX == endingX) {
                                if (Math.abs(startingY - endingY) != blocks - 1) {
                                    System.out.println("Invalid coordinates.");
                                } else {

                                    hasAdjacentBlocks = false;
                                    for (int i = startingY; i <= endingY; i++) {
//                                board[9 - i][startingX] = '#';
                                        if (numOfAdjacentBlocks(board, startingX, i) > 0) {
                                            hasAdjacentBlocks = true;
                                            break;
                                        }
                                    }
                                    if (!hasAdjacentBlocks) {
                                        for (int i = startingY; i <= endingY; i++) {
                                            board[9 - i][startingX] = '#';
                                        }
                                        if (blocks == 2) block2--;
                                        else if (blocks == 3) block3--;
                                        else if (blocks == 4) block4--;
                                        showBoard(board);
                                    } else {
                                        System.out.println("Can't place the ship. There is a ship adjacent to the entered coordinates.");
                                    }

                                }

                            } else if (startingY == endingY) {
                                if (Math.abs(startingX - endingX) != blocks - 1) {
                                    System.out.println("Invalid coordinates.");
                                } else {

                                    hasAdjacentBlocks = false;
                                    for (int i = startingX; i <= endingX; i++) {
                                        if (numOfAdjacentBlocks(board, i, startingY) > 0) {
                                            hasAdjacentBlocks = true;
                                            break;
                                        }
                                    }
                                    if (!hasAdjacentBlocks) {
                                        for (int i = startingX; i <= endingX; i++) {
                                            board[9 - startingY][i] = '#';
                                        }
                                        if (blocks == 2) block2--;
                                        else if (blocks == 3) block3--;
                                        else if (blocks == 4) block4--;
                                        showBoard(board);
                                    } else {
                                        System.out.println("Can't place the ship. There is a ship adjacent to the entered coordinates.");
                                    }
                                }
                            } else {
                                System.out.println("Invalid coordinates.");
                            }
                        }else{
                            System.out.println("Invalid coordinates.");
                        }

                    } else {
                        System.out.println("Can't place the ship.");
                    }
                }
            }else if("*".equals(answer)){
                showBoard(board);
            }else if("--reset".equals(answer)){
                System.out.println("Enter the x coordinate of the first block of your ship");
                startingX = scanner.nextInt();
                System.out.println("Enter the y coordinate of the first block of your ship");
                startingY = scanner.nextInt();


                //check if the coordinates are valid
                if (validCoords(startingX, startingY)){
                    if (board[9-startingY][startingX] == '#'){
                        int numOfBlocks = remove(board, startingX, startingY); // removing the ship and getting the number of blocks it had
                        if(numOfBlocks==1) block1++;
                        else if(numOfBlocks==2) block2++;
                        else if(numOfBlocks==3) block3++;
                        else if(numOfBlocks==4) block4++;
                    }else{
                        System.out.println("There is no block of ship in the entered coordinates.");
                    }
                }else{
                    System.out.println("The entered coordinates are out of the bounds of the board");
                }
            }
            else {
                System.out.println("Could not recognize the command");
            }
        }

    }
    public static boolean validCoords(int x, int y){
        return x >= 0 && x <= 9 && y >= 0 && y <= 9;
    }
    public static int remove(char[][] board, int startingX, int startingY){ // returns the number of blocks the removed ship has
        int[][] directions = {
                {startingX-1, startingY},
                {startingX+1, startingY},
                {startingX, startingY-1},
                {startingX, startingY+1}
        };
        int numOfBlocks = 1;
        for(int[] dir : directions){
            int newX = dir[0];
            int newY = dir[1];

            if(validCoords(newX, newY)){
                // get direction(left, right, up, down)
                if(board[9-newY][newX] == '#') {
                    int dx = 0;
                    int dy = 0;
                    dx = Integer.compare(newX, startingX);
                    dy = Integer.compare(newY, startingY);
                    while (validCoords(newX, newY) && board[9-newY][newX]=='#'){
                        board[9-newY][newX] = '.';
                        newX += dx;
                        newY += dy;
                        numOfBlocks++;
                    }
                }


            }
            board[9-startingY][startingX] = '.';

        }
        return numOfBlocks;
    }
    public static void showBoard(char[][] board) {
        System.out.print("  ");
        for (int i = 0; i < 10; i++){
            System.out.print(i+"|");
        }
        System.out.println("");
        System.out.print("  ");
        for(int i = 0; i < 10; i++){
            System.out.print("_ ");
        }
        System.out.println();
        for(int i = 0; i< board.length; i++){
            System.out.print((9-i)+"|");
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == ' ') System.out.print('.'+" ");
                else System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
