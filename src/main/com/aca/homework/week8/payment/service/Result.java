package com.aca.homework.week8.payment.service;

public class Result {
    private int waitingTime;
    private int paymentAmount;

    public Result(int time, int pay){
        waitingTime = time;
        paymentAmount = pay;
    }

    public static Result resultOf(int time, int pay){
        return new Result(time, pay);
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }
}
