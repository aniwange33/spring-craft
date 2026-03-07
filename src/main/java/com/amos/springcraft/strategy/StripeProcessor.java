package com.amos.springcraft.strategy;

import org.springframework.stereotype.Service;

@Service
public class StripeProcessor implements PaymentProcessor {
    @Override
    public void processPayment() {
        System.out.println("processing payment with Stripe");
    }

    @Override
    public String toString() {
        return   "PaymentProcessor";
    }
}
