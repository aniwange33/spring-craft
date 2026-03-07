package com.amos.springcraft.strategy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v{version}/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/{type}", version = "1.0")
    public ResponseEntity<?>processPayment(@PathVariable String type) {
        paymentService.processPayment(type);
        return ResponseEntity.ok("Success");
    }
}
