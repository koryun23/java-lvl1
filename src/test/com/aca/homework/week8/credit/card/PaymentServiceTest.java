package com.aca.homework.week8.credit.card;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class PaymentServiceTest {
    PaymentService testSubject;

    @BeforeEach
    public void setUp(){
        testSubject = new PaymentService();
    }

    @Test
    public void testWhenBalanceIs100AndAmountIs150(){
        CreditCard creditCard = new CreditCard(100, 1);
        Assertions.assertThrows(InsufficientBalanceException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.pay(creditCard, 150);
            }
        });
    }

    @Test
    public void testWhenBalanceIs100AmountIs30Call4Times(){
        CreditCard creditCard = new CreditCard(100, 1);
        int countOfPayments = 0;
        while(countOfPayments < 3){
            countOfPayments++;
            testSubject.pay(creditCard, 30);
        }
        countOfPayments++; // = 4
        Assertions.assertThrows(InsufficientBalanceException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                testSubject.pay(creditCard, 30);
            }
        });
        Assertions.assertEquals(10, creditCard.getBalance());
        Assertions.assertEquals(4, countOfPayments);
    }
}