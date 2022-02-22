package com.aca.homework.week1.divisions;

import java.util.Scanner;

public class Divisions {
    public static void main(String[] args) {
        int[] divisions = new int[5];
        for(int i = 0; i < 5; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number");
            int num1 = scanner.nextInt();
            System.out.println("Enter another number");
            int num2 = scanner.nextInt();

            divisions[i] = num1/num2;
        }
        for(int division : divisions){
            System.out.println(division);
        }
    }
}
