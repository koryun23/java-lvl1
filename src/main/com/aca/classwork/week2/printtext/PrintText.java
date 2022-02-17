package com.aca.classwork.week2.printtext;

public class PrintText {
    public static void main(String[] args) {
        printText("Bari Gisher", 2);
    }
    public static void printText(String text, int seconds){
        for(int i = 0; i < text.length(); i++){
            System.out.println(text.charAt(i));
            waitSeconds(seconds);
        }
    }

    public static void waitSeconds(long seconds){
        long startTime = System.currentTimeMillis();
        long lastTime = 0;
        while(lastTime != seconds){
            long currentSec = (System.currentTimeMillis() - startTime) / 1000;
            if(currentSec != lastTime){
                lastTime = currentSec;
            }
        }
    }
}