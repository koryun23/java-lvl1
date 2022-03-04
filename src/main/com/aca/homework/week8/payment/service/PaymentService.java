package com.aca.homework.week8.payment.service;

import java.util.Random;

@Service
public class PaymentService {
    private static int sleep() {
        int millisecondsToWait = new Random().nextInt(600) + 200;
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < millisecondsToWait) ;
        return millisecondsToWait;
    }

    public Result pay(int money) {
        int milliseconds = sleep();
        System.out.printf("Payment is done($%d)", money);
        return new Result(milliseconds, money);
    }
}
