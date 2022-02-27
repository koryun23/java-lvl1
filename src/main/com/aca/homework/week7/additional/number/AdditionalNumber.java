package com.aca.homework.week7.additional.number;

public class AdditionalNumber {
    public static int getAdditionalNumber(int[] firstArray, int[] secondArray) {
        return -1;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 6, 7}, arr2 = {1, 2, 3, 4, 5, 6, 6};
        long startTime = System.currentTimeMillis();
        System.out.println(xorSolution(arr1, arr2));
        System.out.println((double) System.currentTimeMillis() - startTime);
    }


    public static int xorSolution(int[] firstArray, int[] secondArray){
        int xorOfFirstArray = getArrayXor(firstArray);
        int xorOfSecondArray = getArrayXor(secondArray);
        return xorOfFirstArray ^ xorOfSecondArray;
    }

    public static int getArrayXor(int[] arr){
        int xor = 0;
        for(int num : arr){
            xor ^= num;
        }
        return xor;
    }
}
