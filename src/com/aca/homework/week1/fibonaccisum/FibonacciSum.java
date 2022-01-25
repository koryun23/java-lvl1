package com.aca.homework.week1.fibonaccisum;

import java.util.Scanner;

public class FibonacciSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacciSum(n));
    }
    public static int fibonacciSum(int n){
        int sum = 0;
        int prev = 1;
        int current = 0;
        for (int i = 0; i < n; i++){
            int next = current+prev;
            prev = current;
            current = next;
            sum+=current;
        }
        return sum;
    }
}
