package kz.iitu.order.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.order.db.Database;
import kz.iitu.order.model.Customer;
import kz.iitu.order.model.Medicine;
import kz.iitu.order.model.Order;
import kz.iitu.order.service.MedicineService;
import kz.iitu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MedicineService medicineService;

    @Override
    @HystrixCommand(fallbackMethod = "getOrderByIdFallback",
            threadPoolKey = "getOrderById",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "100"),
                    @HystrixProperty(name = "maxQueueSize", value = "50"),
            })
    public Order getOrderById(Long id) {
        Database database = new Database();
        Order order = database.getOrderById(id);
        Medicine medicine = medicineService.getMedicineById(id);
        List<Medicine> orderedMedicines = new ArrayList<>();
        orderedMedicines.add(medicine);
        order.setMedicines(orderedMedicines);
        return order;
    }

    public Order getOrderByIdFallback(Long id) {
        Order order = new Order();
        Medicine medicine = new Medicine();
        medicine.setId(0L);
        medicine.setName("Medicine is not available: Service Unavailable");
        List<Medicine> orderedMedicines = new ArrayList<>();
        orderedMedicines.add(medicine);
        order.setMedicines(orderedMedicines);
        return order;
    }
}
