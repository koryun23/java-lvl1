package com.aca.classwork.week7.timer;

public class GoodTimer implements Timer{
    private Action action;

    public GoodTimer(Action action) {
        this.action = action;
    }

    @Override
    public void start(){
        while(true) {
            wait1Sec();
            action.doAction();
        }
    }
    private void wait1Sec(){
        long startMillis = System.currentTimeMillis();
        while(System.currentTimeMillis()-startMillis < 1000);
    }

}
