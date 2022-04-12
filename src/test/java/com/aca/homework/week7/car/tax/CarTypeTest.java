package com.aca.homework.week7.car.tax;

class CarTypeTest {
    public static void main(String[] args) {
        CarType electric = CarType.ELECTRIC;
        CarType hybrid = CarType.HYBRID;
        System.out.println(electric.annualTax(2022 - 2015));
        System.out.println(hybrid.annualTax(2022 - 2010));
    }
}