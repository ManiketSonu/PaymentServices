package com.mani.example.productservices.paymentservices.Service;


import com.mani.example.productservices.paymentservices.Model.PaymentResponse;
import com.razorpay.RazorpayException;

public interface iPaymentServices {
    PaymentResponse initiatePayment(String customerId, String orderId, String amount) throws RazorpayException;
}
