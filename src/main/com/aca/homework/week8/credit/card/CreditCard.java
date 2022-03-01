package com.aca.homework.week8.credit.card;

public class CreditCard {
    private double balance;
    private int number;

    public CreditCard(double balance, int number) {
        this.balance = balance;
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.format("Credit card(balance: $%.2f, number: %d)", balance, number);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj instanceof CreditCard){
            CreditCard other = (CreditCard) obj;
            return other.balance == this.balance && other.number == this.number;
        }
        return false;
    }
}
