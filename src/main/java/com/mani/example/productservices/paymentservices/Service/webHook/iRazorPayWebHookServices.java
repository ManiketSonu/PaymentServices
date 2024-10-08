package com.mani.example.productservices.paymentservices.Service.webHook;

import com.mani.example.productservices.paymentservices.DTO.WebHook.RazorPayWebHookRequestDTO;

public interface iRazorPayWebHookServices {
    void processEvent(RazorPayWebHookRequestDTO dto);
}
