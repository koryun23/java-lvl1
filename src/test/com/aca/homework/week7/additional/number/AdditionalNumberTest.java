package com.aca.homework.week7.additional.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalNumberTest {

    @Test
    public void testWhenOneArrayIsEmpty() {
        int[] arr1 = {1};
        int[] arr2 = {};
        Assertions.assertEquals(1, AdditionalNumber.getAdditionalNumber(arr1, arr2));
    }

    @Test
    public void testWhenBothArraysHaveOnlyPositiveNumbers() {
        int[] arr1 = {4, 1, 3, 7};
        int[] arr2 = {3, 7, 1};
        Assertions.assertEquals(4, AdditionalNumber.getAdditionalNumber(arr1, arr2));
    }

    @Test
    public void testWhenBothArraysHaveOnlyNegativeNumbers() {
        int[] arr1 = {-4, -1, -3, -7};
        int[] arr2 = {-3, -7, -1};
        Assertions.assertEquals(-4, AdditionalNumber.getAdditionalNumber(arr1, arr2));
    }

    @Test
    public void testWhenBothArraysHaveNegativeAndPositiveNumbers() {
        int[] arr1 = {-4, -1, 3, 7};
        int[] arr2 = {3, 7, -1};
        Assertions.assertEquals(-4, AdditionalNumber.getAdditionalNumber(arr1, arr2));
    }

    @Test
    public void testWhenAllNumbersAreEqualInBothArrays() {
        int[] arr1 = {1, 1, 1, 1};
        int[] arr2 = {1, 1, 1};
        Assertions.assertEquals(1, AdditionalNumber.getAdditionalNumber(arr1, arr2));
    }

    @Test
    public void testWhenAllNumbersAre0InBothArrays() {
        int[] arr1 = {0, 0, 0, 0};
        int[] arr2 = {0, 0, 0};
        Assertions.assertEquals(0, AdditionalNumber.getAdditionalNumber(arr1, arr2));
    }

    @Test
    public void testWhenAdditionalNumberIs0() {
        int[] arr1 = {0, 1, 3, 7};
        int[] arr2 = {3, 7, 1};
        Assertions.assertEquals(0, AdditionalNumber.getAdditionalNumber(arr1, arr2));
    }
}