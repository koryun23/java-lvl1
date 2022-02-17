package com.aca.homework.week3.numbers.max.min;

public class Numbers {
    private int number1;
    private int number2;
    private int number3;
    public Numbers(int number1, int number2, int number3){
        this.number1 = number1;
        this.number2 = number2;
        this.number3 = number3;
    }

    public int max(){
        int max = number1 > number2 ? number1 : number2;
        return max > number3 ? max : number3;
    }

    public int min(){
        int min = number1 < number2 ? number1 : number2;
        return min < number3 ? min : number3;
    }
}
