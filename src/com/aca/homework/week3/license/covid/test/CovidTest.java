package com.aca.homework.week3.license.covid.test;

import java.util.Random;

public class CovidTest {
    private User user;
    private String result = "undefined";
    public void test(){
        waitSeconds(3);
        Random generator = new Random();
        int randomInt = generator.nextInt(100);
        this.result = randomInt > 50 ? "positive" : "negative"; // randomly setting the result, 50-50 chance for each outcome
    }
    public static void waitSeconds(long seconds){
        long startMillis = System.currentTimeMillis();
        long currentMillis = 0;
        while ((currentMillis - startMillis)/1000 < seconds){
            currentMillis = System.currentTimeMillis();
        }
    }
}
