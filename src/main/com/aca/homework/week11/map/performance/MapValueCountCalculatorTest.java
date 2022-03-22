package com.aca.homework.week11.map.performance;

import java.util.Scanner;

public class MapValueCountCalculatorTest {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the type of the map value count calculator(high/low): ");
//        String mapValueCoutnCalculatorType = scanner.nextLine();
//        MapValueCountCalculator calculator = new LowPerformanceMapValueCountCalculator();
//        if("high".equals(mapValueCoutnCalculatorType)){
//            calculator = new HighPerformanceMapValueCountCalculator();
//        }
        long startMillis = System.currentTimeMillis();
        MapValueCountCalculator highPerfCalculator = new HighPerformanceMapValueCountCalculator(16, 0.9f);
        MaxMinStatistics maxMinStatistics = highPerfCalculator.populateAndCalculate(10000);
        System.out.println(maxMinStatistics);
        System.out.println("Execution time of high performance map value count calculator: " + (double) (System.currentTimeMillis() - startMillis) / 1000);

        startMillis = System.currentTimeMillis();
        MapValueCountCalculator lowPerfCalculator = new LowPerformanceMapValueCountCalculator();
        maxMinStatistics = lowPerfCalculator.populateAndCalculate(10000);
        System.out.println(maxMinStatistics);
        System.out.println("Execution time of low performance map value count calculator: " + (double) (System.currentTimeMillis() - startMillis) / 1000);

    }
}
