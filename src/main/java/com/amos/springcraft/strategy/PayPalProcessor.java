package com.amos.springcraft.strategy;

import org.springframework.stereotype.Service;

@Service
public class PayPalProcessor  implements PaymentProcessor {

    @Override
    public void processPayment() {
        System.out.println("processing payment with PayPal");
    }

    @Override
    public String toString() {
        return  "PaymentProcessor";
    }
}
