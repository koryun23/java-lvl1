package com.aca.homework.week4.time;

public class Time {
    private int seconds;

    public Time(int seconds){
        this.seconds = seconds;
    }

    public int getHours(){
        return this.seconds / 3600;
    }
    public int getMinutes(){
        return (this.seconds - (this.getHours()*3600))/60;
    }

    public int getSeconds(){
        return (this.seconds - this.getHours()*3600 - this.getMinutes()*60);
    }

}
