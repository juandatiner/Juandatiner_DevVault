package com.platzi.paymentGateway.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PaymentProcessorTest {

    private PaymentGateway paymentGateway;
    private PaymentProcessor paymentProcessor;

    @Before  //Execute before because in that is common part of Test twice
    public void setup() {

        paymentGateway = Mockito.mock(PaymentGateway.class); //Simulate PaymentGateway
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void payment_correct() {


        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.OK)); //any request is ok

        boolean result=paymentProcessor.makePayment(1000);

        assertTrue(result);
    }

    @Test
    public void payment_incorrect() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentResponse.PaymentStatus.ERROR)); //any request is ok

        assertFalse(paymentProcessor.makePayment(1000));
    }
}