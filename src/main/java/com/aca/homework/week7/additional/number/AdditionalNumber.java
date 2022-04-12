package com.aca.homework.week7.additional.number;


public class AdditionalNumber {
    public static int getAdditionalNumber(int[] firstArray, int[] secondArray) {
        int sumOfFirstArray = sumOfArray(firstArray);
        int sumOfSecondArray = sumOfArray(secondArray);

        return sumOfFirstArray - sumOfSecondArray;

    }
    public static int sumOfArray(int[] arr){
        int sum = 0;
        for(int num : arr){
            sum += num;
        }
        return sum;
    }
}
