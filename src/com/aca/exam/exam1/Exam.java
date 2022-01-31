package com.aca.exam.exam1;

import java.util.Scanner;

public class Exam {
    private int[] numbers;

    public Exam(int[] numbers){
        this.numbers = numbers;
    }
    public int max(){
        // get the maximum number from the 5 inputted numbers
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < this.numbers.length; i++){
            if(this.numbers[i] > max){
                max = this.numbers[i];
            }
        }
        return max;
    }

    public int min(){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < this.numbers.length; i++){
            if(this.numbers[i] < min){
                min = this.numbers[i];
            }
        }
        return min;
    }

    public double average(){
        int sum = 0;
        for(int i = 0; i < this.numbers.length; i++){
            sum+=this.numbers[i];
        }
        return (double) sum / this.numbers.length; // casting to double because both the sum and numbers length are ints, and the return type should be double
    }

    public void printNthNumber(){
        System.out.println("Enter a number in the range of [1;5]");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= this.numbers.length && n >= 1){ // assuming that n is in the range of [1; 5]
            System.out.println(this.numbers[n-1]);
        }
    }

    public int maxMinDifference(){
        return this.max() - this.min();
    }

    public int countOfZeroes(){
        int countOfZeroes = 0;
        for(int i = 0; i < this.numbers.length; i++){
            int currentNumber = this.numbers[i];
            do{
                if (currentNumber % 10 == 0) countOfZeroes++;
                currentNumber /= 10;
            }while(currentNumber != 0);
            // here I used do while instead of while because if the currentNumber is 0, the count of 0s would not increase,
            // and an extra condition would be needed.

            // also, I didn't move the part of counting 0s of a particular number to a method because using static methods
            // was prohibited.

        }
        return countOfZeroes;
    }

    public void doubleNumbers(){
        for(int i = 0; i < this.numbers.length; i++){
            this.numbers[i]*=2;
        }
    }

    public void getResults() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Enter a number in the range of [1;8]");
            int enteredNumber = scanner.nextInt();
            if (enteredNumber == 1) {
                System.out.println("Maximum number is: " + this.max());
            } else if (enteredNumber == 2) {
                System.out.println("Minimum number is: " + this.min());
            } else if (enteredNumber == 3) {
                this.doubleNumbers();
                System.out.println("The numbers' values have been doubled.");
            } else if (enteredNumber == 4) {
                System.out.println("The average of the numbers is: " + this.average());
            } else if (enteredNumber == 5) {
                System.out.println("The n-th number is: ");
                this.printNthNumber();
            } else if (enteredNumber == 6) {
                System.out.println("The difference between the max and min is: " + this.maxMinDifference());
            } else if (enteredNumber == 7) {
                System.out.println("The count of 0s is: " + this.countOfZeroes());
            } else if (enteredNumber == 8) {
                running = false;
                System.out.println("Terminated the program.");
            } else {
                System.out.println("Invalid input.");
            }
        }
    }
}
