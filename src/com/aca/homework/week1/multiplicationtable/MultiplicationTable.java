package com.aca.homework.week1.multiplicationtable;

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of terms: ");
        int n = scanner.nextInt();
        for(int i = 0; i<= n;i++){
            System.out.format("%d x %d = %d\n", n, i, n*i);
        }
    }
}
