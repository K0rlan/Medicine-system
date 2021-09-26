package kz.iitu.order.service.impl;

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

//    @Override
//    public List<Order> getAllOrders() {
//        List<Order> orderList = new ArrayList<>();
//
//        List<Long> orderIds = new ArrayList<>(Arrays.asList(1L, 2L, 4L));
//        for (Long id : orderIds) {
//            Order order = new Order();
//            order.setId(id);
//            Customer customer = new Customer();
//            customer.setId(id);
//            customer.setName("Customer 1");
//            customer.setPhoneNumber("87771112233");
//            order.setCustomer(customer);
//            order.setTotalCost(1000.0);
//
//            Medicine medicine = restTemplate.getForObject("http://localhost:8081/medicines/" + id, Medicine.class);
//            List<Medicine> orderedMedicines = new ArrayList<>();
//            orderedMedicines.add(medicine);
//            order.setMedicines(orderedMedicines);
//            orderList.add(order);
//        }
//        return orderList;
//    }

    @Override
    public Order getOrderById(Long id) {
        Order order = new Order();
        order.setId(id);
        order.setTotalCost(2000.0);
        Medicine medicine = restTemplate.getForObject("http://localhost:8081/medicines/" + id, Medicine.class);
        List<Medicine> orderedMedicines = new ArrayList<>();
        orderedMedicines.add(medicine);
        order.setMedicines(orderedMedicines);
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Customer 1");
        customer.setPhoneNumber("87771112233");
        order.setCustomer(customer);
        return order;
    }
}
