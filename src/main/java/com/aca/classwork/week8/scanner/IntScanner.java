package com.aca.classwork.week8.scanner;

import java.util.Arrays;
import java.util.InputMismatchException;

public class IntScanner {
    IntSupplier intSupplier;
    public IntScanner(IntSupplier supplier){
        intSupplier = supplier;
    }
    public int[] get5SizedArray(){
        int[] array = new int[5];
        int i = 0;
        while(i < 5){
            System.out.println("Enter a number");
            try {
                array[i] = intSupplier.get();
                i++;
            } catch (InputMismatchException e){
                e.printStackTrace();
            }
        }
        return array;
    }

    public int getMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = new IntScanner(new IntSupplier()).get5SizedArray();
        System.out.println(Arrays.toString(array));
        System.out.println(new IntScanner(new IntSupplier()).getMax(array));
    }
}
