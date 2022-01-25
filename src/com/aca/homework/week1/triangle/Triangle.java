package com.aca.homework.week1.triangle;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of rows:");
        int n = scanner.nextInt();
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
