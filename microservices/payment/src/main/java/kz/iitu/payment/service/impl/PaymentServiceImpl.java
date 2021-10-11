package kz.iitu.payment.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.iitu.payment.PaymentDB.PaymentDatabase;
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
    @HystrixCommand(fallbackMethod = "getAllPayment")
    public List<Payment> getAllPayment() {
        PaymentDatabase paymentDatabase = new PaymentDatabase();
        List<Payment> paymentList = paymentDatabase.getPaymentList();

        for (Payment payment: paymentList) {
            Order order = restTemplate.getForObject("http://order-service/orders/" + payment.getId(), Order.class);
            payment.setOrder(order);
        }

        return paymentList;
    }
}
