package kz.iitu.payment.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.payment.model.Order;
import kz.iitu.payment.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getOrderByIdFallback",
            threadPoolKey = "getOrderById",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
            })
    public Order getOrderById(Long id) {
        return restTemplate.getForObject("http://order-service/orders/" + id, Order.class);
    }

    public Order getOrderByIdFallback(Long id) {
        Order order = new Order();
        order.setId(0L);
        order.setTotalCost(0.0);
        return order;
    }
}
