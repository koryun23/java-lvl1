package com.aca.homework.week7.additional.number;

public class AdditionalNumber {
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        return max;
    }

    public static int getAdditionalNumber(int[] firstArray, int[] secondArray) {
        int[] temp  = new int[firstArray.length * 2 - 1];
        for(int i = 0; i < firstArray.length; i++){
            if(temp[firstArray.length-1 + firstArray[i] % firstArray.length] == 0){
                temp[firstArray.length-1 + firstArray[i] % firstArray.length] = 1;
            }else{
                temp[firstArray.length-1 + firstArray[i] % firstArray.length]++;
            }
        }

        for(int i = 0; i < secondArray.length; i++){
            temp[firstArray.length-1+secondArray[i]%firstArray.length]--;
        }

        for(int i = 0; i < temp.length; i++){
            if(temp[i] == 1){
                return firstArray.length;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 2, 5}, arr2 = {2, 4, 1, 3};
        System.out.println(getAdditionalNumber(arr1, arr2));
    }
}
