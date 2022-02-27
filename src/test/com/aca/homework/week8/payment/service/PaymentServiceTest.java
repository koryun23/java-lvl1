package com.aca.homework.week8.payment.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {
    private PaymentService service;
    private Result result;

    @BeforeEach
    public void setUp(){
        service = new PaymentService();
    }

    @Test
    public void testServiceAnnotation(){
        Annotation[] annotations = service.getClass().getDeclaredAnnotations();
        boolean foundServiceAnnotation = false;
        for(Annotation annotation : annotations){
            if(annotation.annotationType() == Service.class) foundServiceAnnotation = true;
        }

        assertTrue(foundServiceAnnotation);
    }

    @Test
    public void testPaymentAmount(){
        result = service.pay(100);
        assertEquals(result.getPaymentAmount(), 100);
    }

    @Test
    public void testDuration(){
        result = service.pay(100);
        int duration = result.getWaitingTime();
        assertTrue(duration >= 200 && duration <= 800);
    }
}