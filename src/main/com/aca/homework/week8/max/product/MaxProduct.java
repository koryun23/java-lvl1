package com.aca.homework.week8.max.product;

public class MaxProduct {
    public static int calculateMaxProduct(int[] array){
        if(array == null) throw new IllegalArgumentException("Array must be non-null");
        if(array.length < 2) throw new IllegalArgumentException("Array length must be >= 2");
        int largestNegativeNumber = Integer.MIN_VALUE;
        int lastNonZeroNumber = 0;
        int maxProduct = 0;
        for(int num : array){
            if(num == 0) continue;
            lastNonZeroNumber = num;
            maxProduct = maxProduct == 0 ? num : maxProduct * num;
            if(num < 0){
                largestNegativeNumber = Math.max(num, largestNegativeNumber);
            }
        }
        if(maxProduct == lastNonZeroNumber) return 0;
        if(maxProduct < 0){
            return maxProduct / largestNegativeNumber;
        }
        return maxProduct;
    }
}
