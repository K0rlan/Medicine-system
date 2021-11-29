package kz.iitu.order.db;

import kz.iitu.order.model.Customer;
import kz.iitu.order.model.Medicine;
import kz.iitu.order.model.Order;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public List<Order> orderList = new ArrayList<>();
    public List<Medicine> medicineList = new ArrayList<>();
    public List<Customer> customerList = new ArrayList<>();

    public Database() {
//        customerList.add(new Customer(1L, "customer1", "111"));
//        customerList.add(new Customer(2L, "customer2", "222"));
//        customerList.add(new Customer(3L, "customer3", "333"));
//        customerList.add(new Customer(4L, "customer4", "444"));

//        orderList.add(new Order(1L, new ArrayList<Medicine>(), customerList.get(0), 1000.0));
//        orderList.add(new Order(2L, new ArrayList<Medicine>(), customerList.get(1), 1100.0));
//        orderList.add(new Order(3L, new ArrayList<Medicine>(), customerList.get(2), 1200.0));
//        orderList.add(new Order(4L, new ArrayList<Medicine>(), customerList.get(3), 1300.0));
    }

    public Customer getCustomerById(long id) {
//        for (Customer customer : customerList) {
//            if (id == customer.getId()) {
//                return customer;
//            }
//        }
        return null;
    }

    public Order getOrderById(long id) {
        for (Order order : orderList) {
            if (id == order.getId()) {
                return order;
            }
        }
        return null;
    }
}
