package com.aca.homework.week5.light.out;


import java.util.Scanner;

public class Game {
    private final Light[][] lights = new Light[5][5];
    private int moves;

    public Game() {
        initialize();
    }

    public void initialize() {
        int[][] offCoords = {
                {0, 2}, {1, 1}, {1, 3}, {2, 0}, {2, 4}, {3, 1}, {3, 3}, {4, 2}
        };
        turnAllLightsOn();
        turnLightsOff(offCoords);
    }
    public void turnAllLightsOn(){
        for (int i = 0; i < lights.length; i++) {
            for (int j = 0; j < lights[i].length; j++) {
                lights[i][j] = new Light(true);
            }
        }
    }
    public void turnLightsOff(int[][] offCoords){
        for (int[] coord : offCoords) {
            lights[coord[0]][coord[1]] = new Light(false);
        }
    }

    public boolean win() {
        for (Light[] row : lights) {
            for (Light light : row) {
                if (light.isOn()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printGame() {
        System.out.print("   ");
        for (int i = 0; i < lights.length; i++) {
            System.out.print(i + " ");
        }

        System.out.println("\n   ---------");
        for (int i = 0; i < lights.length; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < lights[i].length; j++) {
                String currentChar = lights[i][j].toString();
                System.out.print(currentChar + " ");
            }
            System.out.println();
        }
    }

    public void play() {
        System.out.println("Game started!!");

        while (moves == 0 || !win()) {
            printNumberOfMoves();
            printGame();
            int x = getX();
            int y = getY();
            System.out.println();
            if (!isValidCoordinate(x, y)) {
                System.out.println("Invalid coordinates. Please try again");
                continue;
            }
            switchLights(x, y);
            moves++;
        }
        printNumberOfMoves();
        printGame();
        System.out.println("You won!");

    }

    public void printNumberOfMoves() {
        System.out.printf("moves: %d\n", moves);
    }

    public void switchLights(int x, int y) {
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

    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < lights[0].length && y >= 0 && y < lights.length;
    }

    public int getX() {
        System.out.printf("Enter the x of the hit coordinate: [0;%d] ", lights[0].length);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public int getY() {
        System.out.printf("Enter the y of the hit coordinate: [0;%d] ", lights.length);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
