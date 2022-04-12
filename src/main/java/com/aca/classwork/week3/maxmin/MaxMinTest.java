package com.aca.classwork.week3.maxmin;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMinTest {
    public static void main(String[] args) {
//        MaxMin[] maxMinArray = getMaxMins();
//        MaxMin[] maxMinArrayFiltered = getMaxMinFiltered(maxMinArray);
//        getOutput(maxMinArray, maxMinArrayFiltered);
//
        MaxMin maxMin = getMaxMin(1, 5);
        Printers.printMaxMin(maxMin);


    }
    public static void getOutput(MaxMin[] notFiltered, MaxMin[] filtered){
        System.out.println("Before filtering: ");
        printMaxMinArray(notFiltered);
        System.out.println("After filtering: ");
        printMaxMinArray(filtered);

    }

    public static void printMaxMinArray(MaxMin[] maxMinArray){
        for(MaxMin maxMin : maxMinArray){
            System.out.println("Max : " + maxMin.max + ", Min : " + maxMin.min);
        }
    }

    public static MaxMin[] getMaxMinFiltered(MaxMin[] arr){
        int index = 0;
        MaxMin[] maxMinArrayFiltered = new MaxMin[5];
        for(MaxMin maxMin : arr){
            if(maxMin.max > 5){
                maxMinArrayFiltered[index] = maxMin;
                index++;
            }
        }
        return Arrays.copyOf(maxMinArrayFiltered, index);
    }

    public static MaxMin[] getMaxMins(){
        Scanner scanner = new Scanner(System.in);
        MaxMin[] maxMinArray = new MaxMin[5];
        for(int i = 0; i < 5; i++) {
            System.out.println("Please enter a number");
            int number1 = scanner.nextInt();
            System.out.println("Please enter a number");
            int number2 = scanner.nextInt();
            MaxMin maxMin = getMaxMin(number1, number2);
            maxMinArray[i] = maxMin;
        }
        return maxMinArray;
    }
    public static MaxMin getMaxMin(long i, long j){
        MaxMin maxMin = new MaxMin();
        maxMin.max = i > j ? i : j;
        maxMin.min = i > j ? j : i;
        return maxMin;
    }

    public static void printMaxMin(MaxMin maxMin){
        System.out.println("Max: "+maxMin.max+", Min:"+maxMin.min);
    }
}
