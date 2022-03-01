package com.aca.homework.week8.credit.card;

public class PaymentService {
    public void pay(CreditCard creditCard, double amountToBePaid){
        if(creditCard.getBalance() < amountToBePaid){
            throw new InsufficientBalanceException("\n"+creditCard.toString() + "\ncould not transfer $" + amountToBePaid + ", because the balance($" + creditCard.getBalance() + ") is less than the amount to be paid.");
        }
        creditCard.setBalance(creditCard.getBalance() - amountToBePaid);
        System.out.println("The payment was done successfully.");
    }
}
