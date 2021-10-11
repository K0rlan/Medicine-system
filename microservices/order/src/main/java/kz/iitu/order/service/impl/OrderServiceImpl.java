package kz.iitu.order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.iitu.order.db.Database;
import kz.iitu.order.model.Customer;
import kz.iitu.order.model.Medicine;
import kz.iitu.order.model.Order;
import kz.iitu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "getOrderById")
    public Order getOrderById(Long id) {
        Database database = new Database();
        Order order = database.getOrderById(id);
        Medicine medicine = restTemplate.getForObject("http://medicines-service/medicines/" + id, Medicine.class);
        List<Medicine> orderedMedicines = new ArrayList<>();
        orderedMedicines.add(medicine);
        order.setMedicines(orderedMedicines);
        return order;
    }
}
