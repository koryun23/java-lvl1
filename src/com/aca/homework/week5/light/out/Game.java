package com.aca.homework.week5.light.out;


import java.util.Scanner;

public class Game {
    private Light[][] lights = new Light[5][5];
    private int moves;
    public Game(){
        initialize();
    }
    public void initialize(){
        int[][] offCoords = {
                {0, 2}, {1, 1}, {1, 3}, {2, 0}, {2, 4}, {3, 1}, {3, 3}, {4, 2}
        };
        for(int i = 0; i < lights.length; i++){
            for(int j = 0; j < lights[i].length; j++){
                if(contains(offCoords, new int[]{i, j})){
                    lights[i][j] = new Light(false);
                }else{
                    lights[i][j] = new Light(true);
                }
            }
        }
    }
    public static boolean contains(int[][] coords, int[] coord){
        for(int[] currentCoord : coords){
            if(coord[0] == currentCoord[0] && coord[1] == currentCoord[1]){
                return true;
            }
        }
        return false;
    }
    public boolean win(){
        for(Light[] row : lights){
            for(Light light : row){
                if (light.getState().equals("on")){
                    return false;
                }
            }
        }
        return true;
    }
    public void printGame(){
        System.out.print("   ");
        for(int i = 0; i < lights.length; i++){
            System.out.print(i+" ");
        }

        System.out.println("\n   ---------");
        for(int i = 0; i < lights.length; i++){
            System.out.print(i+"| ");
            for(int j = 0; j < lights[i].length; j++){
                char currentChar = lights[i][j].getState().equals("on") ? '+' : '0';
                System.out.print(currentChar+" ");
            }
            System.out.println();
        }
    }
    public void play(){
        System.out.println("Game started!!");

        while(moves==0 || !win()) {
            printNumberOfMoves();
            printGame();
            int x = getX();
            int y = getY();
            System.out.println();
            if(!isValidCoordinate(x, y)){
                System.out.println("Invalid coordinates. Please try again");
                continue;
            }
            switchLights(x, y);
            moves++;
        }
        printGame();
        System.out.println("You won!");

    }
    public void printNumberOfMoves(){
        System.out.printf("moves: %d\n", moves);
    }
    public void switchLights(int x, int y){
        int[][] directions = {
                {x - 1, y},
                {x + 1, y},
                {x, y - 1},
                {x, y + 1},
                {x, y}
        };
        for (int[] dir : directions) {
            int currentX = dir[0];
            int currentY = dir[1];
            if (isValidCoordinate(currentX, currentY)) {
                lights[currentY][currentX].switchState();
            }
        }
    }
    public boolean isValidCoordinate(int x, int y){
        return x >= 0 && x < lights[0].length && y >= 0 && y < lights.length;
    }

    public int getX(){
        System.out.printf("Enter the x of the hit coordinate: [0;%d] ", lights[0].length);
        Scanner scanner = new Scanner(System.in);
        int xCoord = scanner.nextInt();
        return xCoord;
    }
    public int getY(){
        System.out.printf("Enter the y of the hit coordinate: [0;%d] ", lights.length);
        Scanner scanner = new Scanner(System.in);
        int yCoord = scanner.nextInt();
        return yCoord;
    }
}
