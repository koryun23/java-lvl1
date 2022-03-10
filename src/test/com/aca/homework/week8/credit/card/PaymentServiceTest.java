package com.aca.homework.week8.credit.card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PaymentServiceTest {
    private PaymentService testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new PaymentService();
    }

    @Test
    public void testWhenBalanceIs100AndAmountIs150() {
        CreditCard creditCard = new CreditCard(100, 1);
        Assertions.assertThrows(InsufficientBalanceException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.pay(creditCard, 150);
            }
        });
    }

    @Test
    public void testWhenBalanceIs100AmountIs30Call4Times() {
        CreditCard creditCard = new CreditCard(100, 1);
        testSubject.pay(creditCard, 30);
        testSubject.pay(creditCard, 30);
        testSubject.pay(creditCard, 30);
        Assertions.assertThrows(InsufficientBalanceException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.pay(creditCard, 30);
            }
        });
        Assertions.assertEquals(10, creditCard.getBalance());
    }

    @Test
    public void testSetNegativeBalance(){
        CreditCard creditCard = new CreditCard(100, 1);
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                creditCard.setBalance(-5);
            }
        });
    }
}