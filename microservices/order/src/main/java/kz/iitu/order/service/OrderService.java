package kz.iitu.order.service;

import kz.iitu.order.model.Medicine;
import kz.iitu.order.model.Order;

import java.util.List;

public interface OrderService {
//    List<Order> getAllOrders();
    Order getOrderById(Long id);
}
