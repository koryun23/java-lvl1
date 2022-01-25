package com.aca.homework.week1.sumofoddnums;

import java.util.Scanner;

public class SumOfOddNums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int odd = 1;
        System.out.print("The odd numbers are: ");
        for(int i = 0; i< n;i++){
            System.out.print(odd);
            sum+=odd;
            odd+=2;
            if(i<n-1){
                System.out.print(", ");
            }
        }
        System.out.format("\nThe sum of odd natural numbers up to %d terms is %d", n, sum);
    }
}
