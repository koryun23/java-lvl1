package com.aca.homework.week1.countof10;

import java.util.Scanner;

public class CountOf10 {
    public static void main(String[] args) {
        boolean countIs10 = count10();
        String output = countIs10 ? "Yes" : "No";
        System.out.println(output);
    }

    public static boolean count10(){
        System.out.println("Enter a number");
        Scanner scanner = new Scanner(System.in);
        int counter = 0; // counts the numbers equal to 10
        for(int i = 0; i < 6; i++){
            int num = scanner.nextInt();
            if (num == 10){
                counter++;
            }
        }
        return counter==1;
    }
}
