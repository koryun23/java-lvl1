package com.aca.homework.week1.sumofinput;

import java.util.Scanner;

public class SumOfInputtedNums {
    public static void main(String[] args) {

    }

    public static int sum1(){
        //with arrays
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[100];
        int sum = 0;
        for(int i = 0; i < 100; i++){
            System.out.println("Enter a number");
            int num = scanner.nextInt();
            nums[i] = num;
        }

        for(int num : nums){
            sum+=num;
        }

        return sum;

    }

    public static int sum2() {
        // without arrays
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println("Enter a number");
            int num = scanner.nextInt();
            sum+=num;
        }

        return sum;
    }
}
