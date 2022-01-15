package homework3;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        char[][] board = new char[10][10];
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = '.';
            }
        }
        placeShips(board);
        for(int i = 0; i < 10; i++) {
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
    public static void placeShips(char[][] board) {
        int block1 = 4;
        int block2 = 3;
        int block3 = 2;
        int block4 = 1;
        while (block1 > 0 || block2 > 0 || block3 > 0 || block4 > 0) {
            System.out.println("How many blocks do you want your ship to have(1, 2, 3, 4)");
            Scanner scanner = new Scanner(System.in);
            int blocks = scanner.nextInt();
            int startingX = -1, startingY = -1, endingX = -1, endingY = -1;
            if (blocks == 1) {
                if (block1 > 0) {
                    System.out.println("Write the x coordinate for your ship: [0-9]");
                    startingX = scanner.nextInt();
                    System.out.println("Write the y coordinate for your ship: [0-9]");
                    startingY = scanner.nextInt();
                    if (startingX < 0 || startingX > 9 || startingY < 0 || startingY > 9){
                        System.out.println("Invalid coordinates.");
                    }else {
                        board[9 - startingY][startingX] = '#'; // place a ship there
                        showBoard(board);
                        block1--;
                    }
                }else{
                    System.out.println("Can't place the ship.");
                }
            } else {
                int block = 0;
                if (blocks == 2) {
                    block = block2;
                }else if(blocks == 3){
                    block = block3;
                }else if(blocks == 4){
                    block = block4;
                }
                if(block > 0) {
                    System.out.println("Write the x coordinate of the first block of your ship: [0-9]");
                    startingX = scanner.nextInt();
                    System.out.println("Write the y coordinate of the first block of your ship: [0-9]");
                    startingY = scanner.nextInt();

                    System.out.println("Write the x coordinate of the last block of your ship: [0-9]");
                    endingX = scanner.nextInt();
                    System.out.println("Write the y coordinate of the last block of your ship: [0-9]");
                    endingY = scanner.nextInt();

                    if (startingX == endingX){
                        if (Math.abs(startingY-endingY) >= blocks){
                            System.out.println("Invalid coordinates.");
                        }else {
                            for (int i = startingY; i <= endingY; i++) {
                                board[9 - i][startingX] = '#';
                            }
                            if (blocks == 2) block2--;
                            else if(blocks==3) block3--;
                            else if(blocks==6) block4--;
                            showBoard(board);
                        }
                    }else if(startingY == endingY){
                        if (Math.abs(startingX-endingX) >= blocks){
                            System.out.println("Invalid coordinates.");
                        }else {
                            for (int i = startingX; i <= endingX; i++) {
                                board[9 - startingY][i] = '#';
                            }
                            if (blocks == 2) block2--;
                            else if(blocks==3) block3--;
                            else if(blocks==4) block4--;
                            showBoard(board);
                        }
                    }else{
                        System.out.println("Invalid coordinates.");
                    }

                }else{
                    System.out.println("Can't place the ship.");
                }
            }

        }

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
