package com.mani.example.productservices.paymentservices.Controller.WebHook;

import com.mani.example.productservices.paymentservices.DTO.WebHook.RazorPayWebHookRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RazorPayWebHook {

    @PostMapping("/webhook/razorpay")
    public void orderStatus(@RequestBody RazorPayWebHookRequestDTO razorPayWebHookRequestDTO) {

    }
}
