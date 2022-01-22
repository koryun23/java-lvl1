package com.aca.homework.week2.pattern;

public class PatternTest {
    public static void main(String[] args) {
        char[][] matrix = new char[5][5];
        fillMatrix(matrix, '0');
        System.out.println("Before");
        printMatrix(matrix);
        addPattern2Right2Top(matrix, 1,2);
        System.out.println("After");
        printMatrix(matrix);

    }
    public static void fillMatrix(char[][] matrix, char ch){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = ch;
            }
        }
    }

    public static boolean addPattern3Right(char[][] matrix, int y, int x){ // method returns true if it could place the ship
        if(x+3>matrix.length){
            return false;
        }
        for(int i = x; i < x+3;i++){
            matrix[y][i] = '*';
        }
        return true;
    }

    public static boolean addPattern2Right2Top(char[][] matrix, int y, int x){
        if(x+1 > matrix.length || y-2 < 0){
            return false;
        }
        for(int i = x; i <= x+1; i++){
            matrix[y][x] = '*';
        }
        for(int i = y; i >= y-2; i--){
            matrix[i][x+1] = '*';
        }
        return true;
    }
    public static void printMatrix(char[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
