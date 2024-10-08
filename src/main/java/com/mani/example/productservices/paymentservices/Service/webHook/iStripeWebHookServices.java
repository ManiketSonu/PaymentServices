package com.mani.example.productservices.paymentservices.Service.webHook;

import com.mani.example.productservices.paymentservices.DTO.WebHook.StripeWebHookRequestDTO;

public interface iStripeWebHookServices {
    void processEvent(StripeWebHookRequestDTO dto);

}
