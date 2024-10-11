package com.platzi.paymentGateway.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
