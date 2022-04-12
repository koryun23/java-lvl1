package com.aca.homework.week8.credit.card;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(CreditCard creditCard, double amountToBePaid) {
        super("\n" + creditCard.toString() + "\ncould not transfer $" + amountToBePaid + ", because the balance($" + creditCard.getBalance() + ") is less than the amount to be paid.");
    }
}
