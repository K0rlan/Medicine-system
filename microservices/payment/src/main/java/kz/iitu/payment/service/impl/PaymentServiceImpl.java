package kz.iitu.payment.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.payment.PaymentDB.PaymentDatabase;
import kz.iitu.payment.model.Order;
import kz.iitu.payment.model.Payment;
import kz.iitu.payment.repository.PaymentRepository;
import kz.iitu.payment.service.OrderService;
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

    @Autowired
    private OrderService orderService;

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    @HystrixCommand(fallbackMethod = "getAllPaymentFallback",
            threadPoolKey = "getAllPayment",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public List<Payment> getAllPayment() {
//        PaymentDatabase paymentDatabase = new PaymentDatabase();
//        List<Payment> paymentList = paymentDatabase.getPaymentList();
        List<Payment> paymentList = paymentRepository.findAll();
        for (Payment payment : paymentList) {
            Order order = orderService.getOrderById(payment.getId());
            payment.setOrder(order);
        }

        return paymentList;
    }

    public List<Payment> getAllPaymentFallback() {
        List<Payment> paymentList = new ArrayList<>();

            Order order = new Order();
            order.setId(0L);
            order.setTotalCost(0.0);
            Payment payment = new Payment();
            payment.setOrder(order);
            payment.setStatus("Fallback");

        return paymentList;
    }
}
