package kz.iitu.payment.PaymentDB;

import kz.iitu.payment.model.Order;
import kz.iitu.payment.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentDatabase {
    public List<Payment> paymentList = new ArrayList<>();

    public PaymentDatabase() {
        paymentList.add(new Payment(1L, "cash", "on a way", new Order()));
        paymentList.add(new Payment(2L, "card", "prepare", new Order()));
        paymentList.add(new Payment(3L, "cash", "on a way", new Order()));
        paymentList.add(new Payment(4L, "card", "on a way", new Order()));
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }
}
