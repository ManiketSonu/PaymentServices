package com.mani.example.productservices.paymentservices.Service;


import com.mani.example.productservices.paymentservices.Model.PaymentResponse;

public interface iPaymentServices {
    PaymentResponse initiatePayment(String customerId, String orderId, String amount);
}
