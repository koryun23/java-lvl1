package com.aca.exam.exam1;

import java.util.Scanner;

public class ExamTest {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            System.out.println("Enter a number");
            numbers[i] = scanner.nextInt();
        }
        Exam exam = new Exam(numbers);
        exam.getResults();
    }
}
