package com.aca.homework.week8.max.product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxProductTest {
    @Test
    public void testCase1() {
        int[] arr = {5, 5, 0, 0, -9};
        Assertions.assertEquals(25, MaxProduct.calculateMaxProduct(arr));
    }

    @Test
    public void testCase2() {
        int[] arr = {5, -5, -5, -9, -1};
        Assertions.assertEquals(1125, MaxProduct.calculateMaxProduct(arr));
    }

    @Test
    public void testCase3() {
        int[] arr = {0, 0, 0, 1, 0};
        Assertions.assertEquals(0, MaxProduct.calculateMaxProduct(arr));
    }

    @Test
    public void testCase4() {
        int[] arr = {0, 0, 0, -1, 0};
        Assertions.assertEquals(0, MaxProduct.calculateMaxProduct(arr));

    }

    @Test
    public void testCase5() {
        int[] arr = {9, 8, 7, 7};
        Assertions.assertEquals(3528, MaxProduct.calculateMaxProduct(arr));
    }

    @Test
    public void testCase6() {
        int[] arr = {5, -5, -5, -9};
        Assertions.assertEquals(225, MaxProduct.calculateMaxProduct(arr));
    }

    @Test
    public void testCase7() {
        int[] arr = {0, 0, 0, 0, 0};
        Assertions.assertEquals(0, MaxProduct.calculateMaxProduct(arr));
    }

    @Test
    public void testCase8() {
        int[] arr = {-1, -2, -3, -4, -5};
        Assertions.assertEquals(120, MaxProduct.calculateMaxProduct(arr));
    }

    @Test
    public void testCase9() {
        int[] arr = {-1, -2, -3, -4, -5, -6};
        Assertions.assertEquals(720, MaxProduct.calculateMaxProduct(arr));
    }
}