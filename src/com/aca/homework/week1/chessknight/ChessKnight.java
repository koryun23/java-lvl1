package com.aca.homework.week1.chessknight;

import java.util.Arrays;
import java.util.Scanner;

public class ChessKnight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the starting position of the knight:(a4, b3...)");
        String coord1 = scanner.nextLine();
        System.out.println("Enter the target position of the knight: (a4, b3...)");
        String coord2 = scanner.nextLine();
        String output = isAPossibleMove(coord1, coord2) ? "Yes" : "No";
        System.out.println(output);
    }
    public static String[] getPossibleMoves(String startingPos){
        int col = letterToIndex(startingPos.charAt(0)+""); //0
        int row = Integer.parseInt(startingPos.charAt(startingPos.length()-1)+"")-1;//2
        int[][] directions = {
                {row-1, col-2},
                {row-1, col+2},
                {row+1, col-2},
                {row+1, col+2},
                {row-2, col-1},
                {row-2, col+1},
                {row+2, col-1},
                {row+2, col+1}
        };
        String[] possibleMoves = new String[8];
        int index = 0;
        for(int[] dir : directions){
            int newY = dir[0];
            int newX = dir[1];
            if(newX >= 0 && newX <= 7 && newY >= 0 && newY <= 7){
                String letter = indexToLetter(newX);
                String move = letter+(newY+1);
                possibleMoves[index++] =move;
            }
        }
        return possibleMoves;

    }
    public static String indexToLetter(int index){
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
        return letters[index];
    }
    public static int letterToIndex(String letter){
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"};
        for(int i = 0; i < letters.length; i++){
            if(letters[i].equals(letter)){
                return i;
            }
        }
        return -1;
    }

    public static boolean isAPossibleMove(String coord1, String coord2){
        String[] possibleMoves = getPossibleMoves(coord1);
        for(String possibleMove : possibleMoves){
            if(coord2.equals(possibleMove)){
                return true;
            }
        }
        return false;

    }
}