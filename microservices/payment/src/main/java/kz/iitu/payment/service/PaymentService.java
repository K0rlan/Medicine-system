package kz.iitu.payment.service;

import kz.iitu.payment.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayment();
}
