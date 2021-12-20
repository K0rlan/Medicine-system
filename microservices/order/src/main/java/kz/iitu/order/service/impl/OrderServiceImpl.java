package kz.iitu.order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.order.db.Database;
import kz.iitu.order.model.Customer;
import kz.iitu.order.model.Medicine;
import kz.iitu.order.model.Order;
import kz.iitu.order.repository.CustomerRepository;
import kz.iitu.order.repository.OrderRepository;
import kz.iitu.order.service.MedicineService;
import kz.iitu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MedicineService medicineService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @HystrixCommand(fallbackMethod = "getOrderByIdFallback",
            threadPoolKey = "getOrderById",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public Order getOrderById(Long id) {
//        Database database = new Database();
//        Order order = database.getOrderById(id);
        Order order = orderRepository.findOrderById(id);
        Customer customer = customerRepository.findCustomerById(order.getCustomer().getId());
        order.setCustomer(customer);
        Medicine medicine = medicineService.getMedicineById(id);
//        System.out.println("medicine.getName(): " + medicine.getName());
//        List<Medicine> orderedMedicines = new ArrayList<>();
//        orderedMedicines.add(medicine);
        Double totalCost = 0.0;
//        Customer customer =
        StringBuilder medicinesString = new StringBuilder();
            medicinesString.append(medicine.getName());
            totalCost = medicine.getPrice();
        order.setMedicines(medicinesString.toString());
        order.setTotalCost(totalCost);
        order = orderRepository.save(order);
        return order;
    }

    public Order getOrderByIdFallback(Long id) {
        Order order = new Order();
        Medicine medicine = new Medicine();
        medicine.setId(0L);
        medicine.setName("Medicine is not available: Service Unavailable");
        order.setMedicines(medicine.getName());
        return order;
    }
}
