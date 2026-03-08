package com.amos.springcraft.strategy;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentService {
     //has a PaymentProcessor
    private final Map<String, PaymentProcessor> paymentProcessors;

    public PaymentService(Map<String, PaymentProcessor> paymentProcessors) {
        this.paymentProcessors = paymentProcessors;
        System.out.println(paymentProcessors);
    }

    public void processPayment(String type) {
        PaymentProcessor paymentProcessor = paymentProcessors.get(type + "Processor");
        if (paymentProcessor == null) {
            throw new IllegalArgumentException("Payment type not supported: " + type);
        }
        paymentProcessor.processPayment();
    }
}
