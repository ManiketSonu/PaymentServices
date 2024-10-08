package com.mani.example.productservices.paymentservices.Controller;


import com.mani.example.productservices.paymentservices.DTO.PaymentRequestDto;
import com.mani.example.productservices.paymentservices.DTO.PaymentResponseDTO;
import com.mani.example.productservices.paymentservices.Model.PaymentResponse;
import com.mani.example.productservices.paymentservices.Service.iPaymentServices;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class PaymentController {

    private iPaymentServices razorPayService;
    private iPaymentServices stripePayServices;


    public PaymentController(@Qualifier("razorPayPaymentServices") iPaymentServices razorPayService,
                             @Qualifier("stripePaymentServices") iPaymentServices stripePayServices) {
        this.razorPayService = razorPayService;
        this.stripePayServices = stripePayServices;
    }

    @PostMapping("/payment/customer")
    public PaymentResponseDTO makePayment(@RequestBody PaymentRequestDto paymentRequestDto)
    {
        //s.1 validate the input
        if(!isValidRequest(paymentRequestDto))
        {
            //Throw exception from here or return ResponseEntity with proper messages

        }

        //s.2
        iPaymentServices paymentServices = getPaymentGateway();

        //s.3 call payment service and get response
        PaymentResponse response = paymentServices.initiatePayment(paymentRequestDto.getCustomerId(),
                paymentRequestDto.getOrderId(), paymentRequestDto.getAmount());

        //s.4 convert and return
        return convertToPaymentResponseDTO(response);
    }

    private PaymentResponseDTO convertToPaymentResponseDTO(PaymentResponse response) {
        return new PaymentResponseDTO();
    }

    private iPaymentServices getPaymentGateway() {
        Random random = new Random();
        switch (random.nextInt(2))
        {
            case 1:
                return this.razorPayService;
            case 2:
                return this.stripePayServices;
            default:
                return this.stripePayServices;
        }
    }

    private boolean isValidRequest(PaymentRequestDto paymentRequestDto) {
        return true;
    }
}
