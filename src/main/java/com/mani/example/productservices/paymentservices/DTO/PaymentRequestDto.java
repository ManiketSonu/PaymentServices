package com.mani.example.productservices.paymentservices.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentRequestDto {
    private String customerId;
    private String orderId;
    private String amount;
}
