package iitu.kz.completed_order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import iitu.kz.completed_order.model.CompletedOrder;
import iitu.kz.completed_order.model.Payment;
import iitu.kz.completed_order.repository.CompletedOrderRepository;
import iitu.kz.completed_order.service.CompletedOrderService;
import iitu.kz.completed_order.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompletedOrderServiceImpl implements CompletedOrderService {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CompletedOrderRepository completedOrderRepository;

    @Override
    @HystrixCommand(fallbackMethod = "getAllCompletedOrderFallback",
            threadPoolKey = "getAllCompletedOrder",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public List<CompletedOrder> getAllCompletedOrder() {
//        PaymentDatabase paymentDatabase = new PaymentDatabase();
//        List<Payment> paymentList = paymentDatabase.getPaymentList();
        List<Payment> payments = paymentService.getAllPayment();
        System.out.println("###Payyyyy " + payments);
        List<CompletedOrder> completedOrders = completedOrderRepository.findAll();
        for (Payment payment : payments) {
            if (payment.getStatus().equals("done")) {
                CompletedOrder completedOrder = new CompletedOrder();
                completedOrder.setOrderPayment(payment.getOrderPayment());
                completedOrder.setOrderPaymentId(payment.getId());
                completedOrders.add(completedOrder);
                completedOrder = completedOrderRepository.save(completedOrder);
            }
        }
        return completedOrders;
    }

    public List<CompletedOrder> getAllCompletedOrderFallback() {
        List<CompletedOrder> completedOrders = new ArrayList<>();
        CompletedOrder completedOrder = new CompletedOrder(1L, 1L, 0.0);
        completedOrders.add(completedOrder);
        return completedOrders;
    }
}
