package kz.iitu.payment.controller;

import kz.iitu.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("")
    public ResponseEntity<?> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayment());
    }
}
