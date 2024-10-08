package com.mani.example.productservices.paymentservices.Service;

import com.mani.example.productservices.paymentservices.Model.PaymentResponse;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("razorPayPaymentServices")
public class RazorPayPaymentServices implements iPaymentServices{

    private RazorpayClient razorpayClient;
    public RazorPayPaymentServices(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public PaymentResponse initiatePayment(String customerId, String amount, String orderId) throws RazorpayException {
        //S1.
        JSONObject orderRequest = createOrderRequestForRazorpay(customerId, amount, orderId);
        Order order = razorpayClient.orders.create(orderRequest);
        return new PaymentResponse(order);
    }


    @NotNull
    private JSONObject createOrderRequestForRazorpay(String customerId, String amount, String orderId) {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", "some_receipt_random_number");
        return orderRequest;
    }
}

