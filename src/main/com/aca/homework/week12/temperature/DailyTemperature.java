package com.aca.homework.week12.temperature;

public class DailyTemperature {

    private int dayNumber;
    private double degree;

    public DailyTemperature(int dayNumber, double degree) {
        setDayNumber(dayNumber);
        setDegree(degree);
    }

    private void setDayNumber(int dayNumber){
        if(dayNumber < 0 || dayNumber > 365)
            throw new IllegalArgumentException("The day number must be in the range of [1; 365]");
        this.dayNumber = dayNumber;
    }

    private void setDegree(double degree) {
        if(degree < 0)
            throw new IllegalArgumentException("The degree must be greater than 0");
        this.degree = degree;
    }

    public int getDayNumber(){
        return dayNumber;
    }

    public double getDegree() {
        return degree;
    }

    @Override
    public String toString(){
        return String.format("DailyTemperature[DAYNUMBER=%d, DEGREE=%.2f]", dayNumber, degree);
    }
}
