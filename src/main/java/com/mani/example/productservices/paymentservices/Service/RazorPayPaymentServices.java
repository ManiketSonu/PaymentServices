package com.mani.example.productservices.paymentservices.Service;

import com.mani.example.productservices.paymentservices.Model.PaymentResponse;
import org.springframework.stereotype.Service;

@Service("razorPayPaymentServices")
public class RazorPayPaymentServices implements iPaymentServices{
    @Override
    public PaymentResponse initiatePayment(String customerId, String orderId, String amount) {

        return new PaymentResponse();
    }
}
