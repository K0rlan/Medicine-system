package kz.iitu.payment.service.impl;

import kz.iitu.payment.model.Order;
import kz.iitu.payment.model.Payment;
import kz.iitu.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Payment> getAllPayment() {
        List<Payment> paymentList = new ArrayList<>();

        List<Long> paymentIds = new ArrayList<>(Arrays.asList(1L, 2L, 4L));
        for (Long id : paymentIds) {
            Payment payment = new Payment();
            payment.setId(id);
            payment.setStatus("not paid");
            payment.setType("buy cash");
            Order order = restTemplate.getForObject("http://localhost:8083/orders/" + id, Order.class);
            payment.setOrder(order);
            paymentList.add(payment);
        }

        return paymentList;
    }
}
