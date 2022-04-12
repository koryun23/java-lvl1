package com.aca.homework.week8.payment.service;

public class Result {
    private final int waitingTime;
    private final int paymentAmount;

    public Result(int time, int pay) {
        waitingTime = time;
        paymentAmount = pay;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }
}
