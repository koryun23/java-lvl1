package com.aca.classwork.week7.timer;

public class BadTimer implements Timer{
    @Override
    public void start(){
        int number = 0;
        while (true){
            wait1Sec();
            number++;
            System.out.println(number);
        }
    }

    private void wait1Sec(){
        long startMillis = System.currentTimeMillis();
        while(System.currentTimeMillis()-startMillis < 1000);
    }
}
